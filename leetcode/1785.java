package leetcode;

class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int n : nums) {
            sum += n;
        }

        long diff = Math.abs((long) goal - sum);
        int res = (int) ((diff + limit - 1) / limit);

        return res;
    }
}