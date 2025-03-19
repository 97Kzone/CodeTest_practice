package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_12785 {

    static int w, h, x, y;
    static long[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        board = new long[h+1][w+1];

        long res = 0;
        long v1, v2;
        if (w == x && h == y) {
            res = check(1, 1, w, h);
        } else {
            v1 = check(1, 1, x, y);
            v2 = check(x, y, w, h);

            res = (v1 * v2) % 1_000_007;
        }

        System.out.print(res);
    }

    static long check(int a, int b, int c, int d) {
        board[b][a] = 1;

        for (int i = b; i <= d; i++) {
            for (int j = a; j <= c; j++) {
                if (i == b && j == a) continue;

                board[i][j] = (board[i-1][j] + board[i][j-1]) % 1_000_007;
            }
        }

        return board[d][c] % 1_000_007;
    }

    static void init() {
        for (int i = 1; i <= h; i++) {
            Arrays.fill(board[i], 0L);
        }
    }
}
