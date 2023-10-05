package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int[][] dp = new int[2][46];
        dp[0][2] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 3; i <= K; i++) {
            dp[0][i] = dp[0][i - 2] + dp[0][i - 1];
            dp[1][i] = dp[1][i - 2] + dp[1][i - 1];
        }

        System.out.println(dp[0][K] + " " + dp[1][K]);
    }
}
