package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_16956 {

    static int R, C;
    static String[][] board;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new String[R][C];

        String[] s;
        for (int i = 0; i < R; i++) {
            s = br.readLine().split("");

            for (int j = 0; j < C; j++) {
                if (".".equals(s[j])) board[i][j] = "D";
                else board[i][j] = s[j];
            }
        }

        int nx, ny;
        boolean flag = true;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ("W".equals(board[i][j])) {
                    for (int[] move : moves) {
                        nx = i + move[0];
                        ny = j + move[1];

                        if (!isPossible(nx, ny)) continue;
                        if ("S".equals(board[nx][ny])) flag = false;
                    }
                }
            }
        }

        if (flag) {
            sb.append("1" + "\n");
            for (String[] line : board) {
                for (int i = 0; i < C; i++) sb.append(line[i]);
                sb.append("\n");
            }
        } else {
            sb.append("0");
        }

        System.out.println(sb);
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < R) && (0 <= y && y < C);
    }
}
