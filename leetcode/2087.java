package leetcode;

class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int res = 0;

        int sr = startPos[0];
        int sc = startPos[1];
        int tr = homePos[0];
        int tc = homePos[1];

        if (sr < tr) {
            for (int r = sr + 1; r <= tr; r++) {
                res += rowCosts[r];
            }
        } else {
            for (int r = sr - 1; r >= tr; r--) {
                res += rowCosts[r];
            }
        }

        if (sc < tc) {
            for (int c = sc + 1; c <= tc; c++) {
                res += colCosts[c];
            }
        } else {
            for (int c = sc - 1; c >= tc; c--) {
                res += colCosts[c];
            }
        }

        return res;
    }
}
