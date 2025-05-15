package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_28215 {

    static int N, K, res;
    static int[][] board;
    static int[] std;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        res = Integer.MAX_VALUE;

        board = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
        }

        std = new int[K];
        check(0, 0);
        System.out.print(res);
    }

    static void check(int d, int idx) {
        int min, max;
        int v1, v2;
        if (d == K) {
            max = 0;
            for (int i = 0; i < N; i++) {
                min = Integer.MAX_VALUE;

                for (int j = 0; j < K; j++) {
                    v1 = std[j];
                    v2 = Math.abs(board[i][0] - board[v1][0]) + Math.abs(board[i][1] - board[v1][1]);
                    min = Math.min(min, v2);
                }

                max = Math.max(max, min);
            }

            res = Math.min(res, max);
            return;
        }

        for (int i = idx; i < N; i++) {
            std[d] = i;
            check(d + 1, i + 1);
        }
    }
}
