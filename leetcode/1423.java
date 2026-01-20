package leetcode;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int res = 0;
        int N = cardPoints.length;

        int sum = 0;
        for (int card : cardPoints) sum += card;

        int std = 0;
        for (int i = 0; i < N - k; i++) std += cardPoints[i];

        res = Math.max(res, sum - std);
        for (int i = N - k; i < N; i++) {
            std -= cardPoints[i - (N - k)];
            std += cardPoints[i];

            res = Math.max(res, sum - std);
        }

        return res;
    }
}