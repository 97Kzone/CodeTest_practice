package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_29733 {
    
    static int R, C, H;
    static char[][][] board;
    static int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new char[H][R][C];
        for (int i = 0 ; i < H; i++) {
            for (int j = 0; j < R; j++) {
                board[i][j] = br.readLine().toCharArray();
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (board[i][j][k] == '*') sb.append("*");
                    else sb.append(check(i, k, j));
                }
                sb.append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    static int check(int z, int x, int y) {
        int res = 0;

        int nx, ny, nz;
        for (int i = -1; i < 2; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0 && j == 4) continue;

                nx = x + moves[j][0];
                ny = y + moves[j][1];
                nz = z + i;

                if (nx < 0 || ny < 0 || nz < 0) continue;
                if (nx >= C || ny >= R || nz >= H) continue;
                if (board[nz][ny][nx] == '.') continue;
                res++;
            }
        }

        return res % 10;
    }
}
