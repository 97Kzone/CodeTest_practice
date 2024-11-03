package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_30052 {

    static int N, M, D, res;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(br.readLine());
        res = 0;

        board = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (Math.abs(i - 1) + Math.abs(j - 1) < D) {
                    board[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (Math.abs(N - i) + Math.abs(j - 1) < D && board[i][j] == 1) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (Math.abs(i - 1) + Math.abs(M - j) < D && board[i][j] == 2) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (Math.abs(N - i) + Math.abs(M - j) < D && board[i][j] == 3) {
                    res++;
                }
            }
        }

        System.out.print(res);
    }
}
