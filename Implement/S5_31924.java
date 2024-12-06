package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_31924 {

    static int N, res;
    static char[][] board;
    static int[][] directions = { { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 } };
    static char[] mobis = { 'O', 'B', 'I', 'S' };
    static char[] sibom = { 'I', 'B', 'O', 'M' };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'M') {
                    search(i, j, mobis);
                } else if (board[i][j] == 'S') {
                    search(i, j, sibom);
                }
            }
        }

        System.out.print(res);
    }

    static void search(int x, int y, char[] sequence) {
        for (int[] dir : directions) {
            int nx = x, ny = y;
            boolean match = true;

            for (int i = 0; i < sequence.length; i++) {
                nx += dir[0];
                ny += dir[1];

                if (!isInBounds(nx, ny) || board[nx][ny] != sequence[i]) {
                    match = false;
                    break;
                }
            }

            if (match) {
                res++;
            }
        }
    }

    static boolean isInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
