package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_17520 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        
        dp[1] = 2;
        dp[2] = 2;
        for (int i = 3; i <= 100000; i++) {
            if (i % 2 == 1) dp[i] = (dp[i - 1] * 2) % 16769023;
            else dp[i] = dp[i - 1];
        }
        
        System.out.print(dp[N]);
    }
}
