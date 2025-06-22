package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_14397 {

    static int N, M, res;
    static char[][] board;

    static int[] dx = {1, 1, -1, -1, 0, 0};
    static int[] dy1 = {-1, 0, -1, 0, 1, -1};
    static int[] dy2 = {1, 0, 1, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '.') continue;
                check(i, j);
            }
        }

        System.out.print(res);
    }

    static void check(int x, int y) {
        int nx, ny;
        for (int i = 0; i < 6; i++) {
            nx = x + dx[i];
            ny = y + (x % 2 == 0 ? dy1[i] : dy2[i]);

            if (isPossible(nx, ny) && board[nx][ny] == '.') {
                res++;
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < M);
    }
}
