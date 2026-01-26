package leetcode;

class Solution {
    public int longestString(int x, int y, int z) {
        int std = 2 * z;

        int min = Math.min(x, y);
        int max = Math.max(x, y);

        std += 4 * min;

        if (max > min) {
            std += 2;
        }

        return std;
    }
}
