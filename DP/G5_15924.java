package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_15924 {

    static int N, M;
    static int[][] dp;
    static String[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        dp = new int[N + 1][M + 1];
        board = new String[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = s[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ("E".equals(board[i][j])) {
                    dp[i][j + 1] = (dp[i][j+1] + dp[i][j] + 1) % 1000000009;
                } else if ("S".equals(board[i][j])) {
                    dp[i + 1][j] = (dp[i+1][j] + dp[i][j] + 1) % 1000000009;
                } else {
                    dp[i][j + 1] = (dp[i][j+1] + dp[i][j] + 1) % 1000000009;
                    dp[i + 1][j] = (dp[i+1][j] + dp[i][j] + 1) % 1000000009;
                }
            }
        }
        System.out.print(dp[N-1][M-1] + 1);
    }
}
