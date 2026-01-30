package leetcode;

class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;
        long INF = Long.MAX_VALUE / 4;

        long[][] cost = new long[n][n];

        int max;
        long sum;
        for (int i = 0; i < n; i++) {
            max = 0;
            sum = 0;
            for (int j = i; j < n; j++) {
                max = Math.max(max, nums[j]);
                sum += nums[j];
                cost[i][j] = (long) max * (j - i + 1) - sum;
            }
        }

        long[][] dp = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int r = 0; r <= k; r++) {
                dp[i][r] = INF;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = cost[0][i];
        }

        for (int r = 1; r <= k; r++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i][r] = Math.min(
                        dp[i][r],
                        dp[j][r - 1] + cost[j + 1][i]
                    );
                }
            }
        }

        long res = INF;
        for (int r = 0; r <= k; r++) {
            res = Math.min(res, dp[n - 1][r]);
        }

        return (int) res;
    }
}