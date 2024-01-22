package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_24464 {

    static int N;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][5];
        
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]) % 1000000007;
            dp[i][1] = (dp[i - 1][3] + dp[i - 1][4]) % 1000000007;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][4]) % 1000000007;
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][4]) % 1000000007;
            dp[i][4] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 1000000007;
        }

        long res = 0;
        for (long v : dp[N]) {
            res = (res + v) % 1000000007;
        }

        System.out.print(res);
    }
}
