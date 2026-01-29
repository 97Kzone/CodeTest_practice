package leetcode;

class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        long len = 1; 

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                len++;
            } else {
                res += len * (len + 1) / 2;
                len = 1;
            }
        }

        res += len * (len + 1) / 2;
        return res;
    }
}
