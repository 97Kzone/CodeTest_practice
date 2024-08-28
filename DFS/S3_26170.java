package DFS;

import java.io.*;
import java.util.*;

public class S3_26170 {

    static int res;
    static int[][] board;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[5][5];
        visit = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        res = Integer.MAX_VALUE;
        visit[R][C] = true;
        check(R, C, 0, 0);

        System.out.print(res == Integer.MAX_VALUE ? -1 : res);
    }
    
    static void check(int x, int y, int v, int cnt) {
        if (cnt == 3) {
            res = Math.min(res, v);
            return;
        }

        int r, c;
        for (int[] move : moves) {
            r = x + move[0];
            c = y + move[1];

            if (!isPossible(r, c) || visit[r][c] || board[r][c] == -1)
                continue;

            visit[r][c] = true;
            if (board[r][c] == 1) {
                check(r, c, v + 1, cnt + 1);
            } else {
                check(r, c, v + 1, cnt);
            }
            visit[r][c] = false;
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < 5) && (0 <= y && y < 5);
    }
}
