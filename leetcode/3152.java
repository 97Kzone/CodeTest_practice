package leetcode;

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int N = nums.length;
        int[] check = new int[N];
        boolean[] res = new boolean[queries.length];

        for (int i = 1; i < N; i++) {
            if ((nums[i] & 1) == (nums[i - 1] & 1)) {
                check[i] = 1;
            }
        }

        for (int i = 1; i < N; i++) {
            check[i] += check[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            res[i] = (check[r] - check[l] == 0);
        }

        return res;
    }
}