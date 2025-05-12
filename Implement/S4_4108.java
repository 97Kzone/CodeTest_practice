package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_4108 {

    static int R, C;
    static char[][] board;
    static int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int x, y;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (R == 0 && C == 0) break;

            board = new char[R][C];
            for (int i = 0; i < R; i++) {
                board[i] = br.readLine().toCharArray();
            }

            int cnt;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == '.') {
                        cnt = 0;
                        for (int[] move : moves) {
                            x = i + move[0];
                            y = j + move[1];

                            if (!isPossible(x, y)) continue;
                            if (board[x][y] == '*') cnt++;
                        }
                        sb.append(cnt);
                    } else {
                        sb.append("*");
                    }
                }
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < R) && (0 <= y && y < C);
    }
}
