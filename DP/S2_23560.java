package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_23560 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        dp[0] = 2;
        
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] * 2 + dp[i - 1];
        }

        System.out.print(dp[N-1]);

    }
}
