package leetcode;

class Solution {
    public int minMoves(int[] nums, int limit) {
        int N = nums.length;
        int pairs = N / 2;
        
        int maxSum = 2 * limit;
        int[] diff = new int[maxSum + 2];

        int a, b, sum;
        int std1, std2;
        for (int i = 0; i < pairs; i++) {
            a = nums[i];
            b = nums[N - 1 - i];

            sum = a + b;
            std1 = Math.min(1 + a, 1 + b);
            std2 = Math.max(limit + a, limit + b);

            diff[std1] -= 1;
            diff[std2 + 1] += 1;

            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int res = Integer.MAX_VALUE;
        int cur = 2 * pairs;

        for (int s = 2; s <= maxSum; s++) {
            cur += diff[s];
            res = Math.min(res, cur);
        }

        return res;
    }
}