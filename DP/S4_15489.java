package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_15489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[31][31];
        dp[0][0] = 1;

        for (int i = 1; i < 31; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        
        for (int i = 2; i < 31; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int res = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j <= i; j++) {
                res += dp[i + R - 1][j + C - 1];
            }
        }

        System.out.print(res);
    }
}
