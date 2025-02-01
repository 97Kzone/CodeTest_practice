package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_32344 {

    static int R, C, N;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        board = new int[N+1][4];
        for (int i = 0; i <= N; i++) {
            board[i][0] = Integer.MAX_VALUE;
            board[i][1] = Integer.MIN_VALUE;
            board[i][2] = Integer.MAX_VALUE;
            board[i][3] = Integer.MIN_VALUE;
        }

        int a, v, h;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board[a][0] = Math.min(v, board[a][0]);
            board[a][1] = Math.max(v, board[a][1]);
            board[a][2] = Math.min(h, board[a][2]);
            board[a][3] = Math.max(h, board[a][3]);
        }

        int idx = 0;
        long res = 0;
        long std;
        for (int i = 1; i <= N; i++) {
            if (board[i][0] == Integer.MAX_VALUE) continue;

            std = (long) (board[i][1] - board[i][0] + 1) * (long) (board[i][3] - board[i][2] + 1);
            if (std > res) {
                res = std;
                idx = i;
            }
        }

        System.out.print(idx + " " + res);
    }
}

