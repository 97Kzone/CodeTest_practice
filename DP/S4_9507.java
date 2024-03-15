package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_9507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[68];
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for (int i = 4; i <= 67; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
        }
        
        int T = Integer.parseInt(br.readLine());
        int N;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            sb.append(dp[N] + "\n");
        }
        System.out.print(sb);
    }
}
