package leetcode;

class Solution {
    public int minOperations(int[] nums) {
        int N = nums.length;

        
        int cnt = 0;
        for (int num : nums) {
            cnt += num == 1 ? 1 : 0;
        }

        if (cnt > 0) {
            return N - cnt;
        }

        int std=  Integer.MAX_VALUE;
        boolean flag = false;
        int tmp;

        for (int i = 0; i < N; i++) {
            tmp = nums[i];

            for (int j = i + 1; j < N; j++) {
                tmp = gcd(tmp, nums[j]);

                if (tmp == 1) {
                    flag = true;
                    std = Math.min(std, j - i);
                    break;
                }
            }
        }

        if (!flag) return -1;

        return std + (N - 1);
    }

    static int gcd(int a, int b) {
        int tmp;
        while (b != 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}