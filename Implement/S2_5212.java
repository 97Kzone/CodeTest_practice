package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_5212 {

    static int R, C;
    static String[][] board, res;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new String[R][C];
        res = new String[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().split("");
            Arrays.fill(res[i], ".");
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (".".equals(board[i][j]))
                    continue;

                check(i, j);
            }
        }

        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ("X".equals(res[i][j])) {
                    x1 = Math.min(x1, i);
                    y1 = Math.min(y1, j);
                    x2 = Math.max(x2, i);
                    y2 = Math.max(y2, j);
                }
            }
        }

        String s;
        for (int i = x1; i <= x2; i++) {
            s = "";
            for (int j = y1; j <= y2; j++) {
                s += res[i][j];
            }
            sb.append(s + "\n");
        }

        System.out.print(sb.toString());
    }

    static void check(int x, int y) {
        int cnt = 0;
        int nx, ny;
        for (int[] move : moves) {
            nx = x + move[0];
            ny = y + move[1];

            if (!isPossible(nx, ny) || ".".equals(board[nx][ny])) {
                cnt++;
            }
        }

        res[x][y] = cnt > 2 ? "." : "X";
    }
    

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < R) && (0 <= y && y < C); 
    }
}
