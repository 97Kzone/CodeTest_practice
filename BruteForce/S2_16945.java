package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_16945 {

    static int[][] board;
    static int[][][] std = {
        {{8, 1, 6}, {3, 5, 7}, {4, 9, 2} },
        {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
        {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
        {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
        {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
        {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
        {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
        {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = Integer.MAX_VALUE;
        int cnt;
        for (int[][] num : std) {
            cnt = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cnt += Math.abs(board[i][j] - num[i][j]);
                }
            }
            res = Math.min(res, cnt);
        }

        System.out.print(res);
    }
}
