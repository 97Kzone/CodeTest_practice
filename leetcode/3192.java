package leetcode;

class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        int n = nums.length;

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && !flag) { 
                flag = true;
                res++;
            }

            if (nums[i] == 1 && flag) {
                flag = false;
                res++;
            }
        }

        return res;
    }
}
