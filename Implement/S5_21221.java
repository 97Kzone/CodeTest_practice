package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_21221 {

    static int N, M;
    static char[][] board;
    static int[][] moves = {{0, 1}, {1, 0}, {1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '.') continue;

                if (board[i][j] == '#') {
                    flip(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(board[i][j] == '.' ? '.' : '#');
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static void flip(int x, int y) {
        int nx, ny;

        for (int[] move : moves) {
            nx = x + move[0];
            ny = y + move[1];

            if (!isPossible(nx, ny)) continue;
            if (board[nx][ny] == '#') continue;
            board[nx][ny] = '*';
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
