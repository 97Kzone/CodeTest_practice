package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_15991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[100001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;

        for (int i = 7; i <= 100001; i++)
            dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1_000_000_009;

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            sb.append(dp[t] + "\n");
        }
        System.out.print(sb);
    }
}
