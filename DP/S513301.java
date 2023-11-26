package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S513301 {
    
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();

        int N = Integer.parseInt(br.readLine());
        System.out.println(dp[N]);
    }
    
    static void init() {
        dp = new long[81];
        dp[1] = 4;
        dp[2] = 6;

        for (int i = 3; i < 81; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    
    }
}
