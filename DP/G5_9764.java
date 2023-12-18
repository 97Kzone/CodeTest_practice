package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_9764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[2001][2001];
        for (int i = 0; i <= 2000; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= 2000; i++) {
            for (int j = 1; j <= 2000; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= j) {
                    dp[i][j] = (dp[i][j] + dp[i - j][j - 1]) % 100999;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        int N;
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N][N] + "\n");
        }

        System.out.print(sb.toString());
    }
}
