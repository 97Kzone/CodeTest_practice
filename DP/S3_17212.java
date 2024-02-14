package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_17212 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[100001];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = 1;

        for (int i = 8; i <= 100000; i++) {
            if (dp[i] == 0) {
                dp[i] = Math.min(Math.min(dp[i - 1], dp[i - 2]), Math.min(dp[i - 5], dp[i - 7])) + 1;
            }
        }

        System.out.print(dp[N]);
    }
}
