package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_11909 {

    static int N, res;
    static int[][] board, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(dp[0], 1000001);
        for (int i = 0; i <= N; i++) dp[i][0] = 1000001;
        
        res = Integer.MAX_VALUE;
        dp[1][1] = 0;
        check();

        System.out.print(dp[N][N]);
    }
    
    static void check() {

        int v1, v2;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 1 && j == 1) continue;

                v1 = board[i][j] - board[i][j - 1];
                v2 = board[i][j] - board[i - 1][j];

                int a, b;
                if (board[i][j] < board[i][j - 1]) a = dp[i][j - 1];
                else a = v1 + 1 + dp[i][j - 1];

                if (board[i][j] < board[i - 1][j]) b = dp[i - 1][j];
                else b = v2 + 1 + dp[i - 1][j];

                dp[i][j] = Math.min(a, b);
            }
        }

    }
}
