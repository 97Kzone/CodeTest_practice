package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_15993 {

    static int T, N;
    static long[][] dp;
    static final int NUM = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N][1] + " " + dp[N][0] + "\n");
        }

        System.out.print(sb);
    }
    
    static void init() {
        dp = new long[100001][2];
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 2;
        
        for (int i = 4; i <= 100000; i++) {
            dp[i][0]= (dp[i-1][1] + dp[i-2][1] + dp[i-3][1]) % NUM;
            dp[i][1]= (dp[i-1][0] + dp[i-2][0] + dp[i-3][0]) % NUM;
        }
    }
}
