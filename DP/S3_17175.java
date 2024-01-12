package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_17175 {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();

        N = Integer.parseInt(br.readLine());
        System.out.print(dp[N]);
    }
    
    static void init() {
        dp = new int[51];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= 50; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1] + 1) % 1000000007;
        }
    }
}
