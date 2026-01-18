package leetcode;

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 * 6 < n2 || n2 * 6 < n1) return -1;

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n1; i++) sum1 += nums1[i];
        for (int i = 0; i < n2; i++) sum2 += nums2[i];

        int[] tmp;
        int v;
        if (sum1 < sum2) {
            tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;

            v = sum1;
            sum1 = sum2;
            sum2 = v;
        }

        int std = sum1 - sum2;

        int[] cnt = new int[6];
        for (int num : nums1) cnt[num - 1]++;
        for (int num : nums2) cnt[6 - num]++;

        int res = 0;
        for (int i = 5; i >= 1 && std > 0; i--) {
            while(cnt[i] > 0 && std > 0) {
                std -= i;
                cnt[i]--;
                res++;
            } 
        }

        return std > 0 ? -1 : res;
    }
}
