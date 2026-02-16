package leetcode;

class Solution {
    public int maximumPossibleSize(int[] nums) {
        int res = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num >= max) {
                res++;
                max = num;
            }
        }

        return res;
    }
}