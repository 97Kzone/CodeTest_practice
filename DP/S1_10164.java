package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_10164 {

    static int N, M, K;
    static int[][] board;
    static int[][] moves = { { 0, 1 }, { 1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i == 1 || j == 1)
                    board[i][j] = 1;
                else
                    board[i][j] = board[i - 1][j] + board[i][j - 1];
            }
        }

        int v1, v2;
        if (K == 0) {
            System.out.print(board[N][M]);
        } else {
            int x1 = ((K - 1) / M) + 1;
            int y1 = K - (x1 - 1) * M;
            int x2 = N - (x1 - 1);
            int y2 = M - (y1 - 1);

            v1 = board[x1][y1];
            v2 = board[x2][y2];

            System.out.print(v1 * v2);
        }
    }
}
