package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_24392 {
    
    static int N, M;
    static int[][] board;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dp = new long[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < M; j++) {
            dp[0][j] = board[0][j];
        }
        
        // 길찾기 시작
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0)
                    continue;

                if (j > 0 && j < M - 1)
                    dp[i][j] += (dp[i - 1][j - 1] + dp[i - 1][j] + dp[i - 1][j + 1]) % 1000000007;
                else if (j == 0)
                    dp[i][j] += (dp[i - 1][j] + dp[i - 1][j + 1]) % 1000000007;
                else
                    dp[i][j] += (dp[i - 1][j - 1] + dp[i - 1][j]) % 1000000007;
            }
        }
        
        // 길 찾았으니 더하자
        long res = 0;
        for (int j = 0; j < M; j++) {
            res += dp[N - 1][j];
            res %= 1000000007;
        }

        System.out.print(res);
    }   
}
