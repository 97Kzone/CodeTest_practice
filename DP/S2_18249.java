package DP;

import java.io.*;

public class S2_18249 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int N;

        int std = 1_000_000_007;
        long[] dp = new long[191229];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < 191229; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % std;
        }

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N-1] + "\n");
        }

        System.out.print(sb);
    }
}
