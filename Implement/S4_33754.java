package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_33754 {

    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[2][N];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 2;
        for (int i = 0; i < N; i++) {
            if (board[0][i] == 0) {
                res = 1;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if (board[1][i] == 1) continue;
            if (board[0][i] == 0 || (i > 0 && board[0][i - 1] == 0) || (i < N - 1 && board[0][i + 1] == 0)) {
                res = 0;
                break;
            } else {
                res = 1;
            }
        }

        System.out.print(res);
    }
}
