package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_16195 {

    static final int MOD_VALUE = 1000000009;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dp = new long[1001][1001];
        for (int i = 0; i < 1001; i++)
            Arrays.fill(dp[i], -1);

        int T = Integer.parseInt(br.readLine());
        int N, M;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            System.out.println(check(N, M));
        }

    }

    static long check(int n, int m) {
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (m == 1) {
            dp[n][m] = (n <= 3) ? 1 : 0;
            return dp[n][m];
        }
        dp[n][m] = (n <= 3) ? 1 : 0;
        for (int i = 1; i <= 3; i++) {
            if (n > i) {
                dp[n][m] += check(n - i, m - 1);
                dp[n][m] %= MOD_VALUE;
            }
        }

        return dp[n][m];
    }
}
