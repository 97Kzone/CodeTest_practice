package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_13699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[36];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        long std;
        for (int i = 4; i < 36; i++) {
            std = 0;

            for (int j = 0; j < i; j++) {
                std += dp[j] * dp[i - 1 - j];
            }
            dp[i] = std;
        }

        System.out.print(dp[N]);
        
    }
}
