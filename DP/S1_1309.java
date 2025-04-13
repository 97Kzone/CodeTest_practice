package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1309 {

    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        init();
        
        System.out.print(dp[N]);
    }

    static void init() {
        dp = new long[N + 1];

        dp[1] = 3;
        dp[2] = 7;

        for (int i = 3; i <= N; i++) {
            dp[i] = ((dp[i-1] * 2) + dp[i-2]) % 9901;
        }
    }
}
