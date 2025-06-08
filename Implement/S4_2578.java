package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_2578 {

    static int[][] board;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        res = 25;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cnt++;
                int std = Integer.parseInt(st.nextToken());

                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        if (board[x][y] == std) {
                            board[x][y] = 0;
                        }
                    }
                }

                if (checkBingo() >= 3) {
                    res = Math.min(res, cnt);
                    
                }
            }
        }

        System.out.print(res);
    }

    static int checkBingo() {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 0) zeroCount++;
            }
            if (zeroCount == 5) count++;
        }

        for (int j = 0; j < 5; j++) {
            int zeroCount = 0;
            for (int i = 0; i < 5; i++) {
                if (board[i][j] == 0) zeroCount++;
            }
            if (zeroCount == 5) count++;
        }

        int lrCount = 0;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] == 0) lrCount++;
        }
        if (lrCount == 5) count++;

        int rlCount = 0;
        for (int i = 0; i < 5; i++) {
            if (board[i][4 - i] == 0) rlCount++;
        }
        if (rlCount == 5) count++;

        return count;
    }
}
