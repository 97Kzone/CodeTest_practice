package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_28075 {

    static int N, M, res;
    static int[][] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[2][3];
        for (int i = 0; i < 2; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                check(i, j, 1, board[i][j]);
            }
        }

        System.out.print(res);
    }

    static void check(int x, int y, int cnt, int std) {
        if (cnt == N) {
            if (std >= M) res++;
            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                check(i, j, cnt + 1, std + (j == y ? board[i][j] / 2 : board[i][j]));
            }
        }
    }
}
