package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G4_2140 {

    static int N, res;
    static char[][] board;
    static int[][] moves = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        res = 0;
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Character.isDigit(board[i][j])) {
                    check(i, j, board[i][j] - '0');
                }

            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '#') {
                    res++;
                }
            }
        }

        System.out.print(res);
    }
    
    static void check(int x, int y, int v) {
        int nx, ny;
        for (int[] move : moves) {
            nx = x + move[0];
            ny = y + move[1];

            if (!isPossible(nx, ny)) {
                continue;
            }

            if (board[nx][ny] == '#' && v != 0) {
                board[nx][ny] = 'O';
                v--;
                res++;
            } else if (board[nx][ny] == 'O' && v != 0) {
                v--;
            } else if (board[nx][ny] == '#' && v == 0) {
                board[nx][ny] = 'X';
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}
