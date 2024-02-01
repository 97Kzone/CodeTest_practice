package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_16456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        if (N > 3) {
            for (int i = 4; i <= N; i++) {
                dp[i] = (dp[i - 3] + dp[i-1]) % 1000000009;
            }
        }
        
        System.out.print(dp[N]);
    }
}
