package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_10157 {

    static int R, C, K;
    static int[][] board;
    static int[][] moves = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        board = new int[R][C];

        if (K > R * C) {
            System.out.print(0);
            return;
        } else if (K == 1) {
            System.out.print("1 1");
            return;
        }

        int x = 0, y = 0;
        int nx, ny, rx, ry;
        int idx = 1;
        board[0][0] = 1;

        for (int i = 0; i < R + C; i++) {
            while (true) {
                nx = x + moves[i % 4][0];
                ny = y + moves[i % 4][1];

                if (!isPossible(nx, ny) || board[nx][ny] != 0) break;

                board[nx][ny] = ++idx;

                if (idx == K) {
                    rx = nx + 1;
                    ry = ny + 1;

                    System.out.println(rx + " " + ry);
                    return;
                }
                x = nx;
                y = ny;
            }
        }
    }
    
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < R) && (0 <= y && y < C);
    }
}
