package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_10476 {

    static int N, K;
    static int[][] board; // 미술관
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N + 1][2];
        dp = new int[N + 2][K + 2][3];

        int a, b;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            board[i][0] = a;
            board[i][1] = b;
        }
        
        br.readLine();

        dp[1][1][0] = board[1][1];
        dp[1][1][1] = board[1][0];
        dp[1][0][2] = board[1][1] + board[1][0];

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if (j >= 1) {
                    dp[i][j][0] = Math.max(dp[i - 1][j - 1][0], dp[i - 1][j - 1][2]) + board[i][1];
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + board[i][0];
                }

                if (i != j) {
                    dp[i][j][2] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j][1], dp[i - 1][j][2]))
                            + board[i][0] + board[i][1];
                }
            }
        }
        System.out.print(Math.max(dp[N][K][0], Math.max(dp[N][K][1], dp[N][K][2])));
    }
}
