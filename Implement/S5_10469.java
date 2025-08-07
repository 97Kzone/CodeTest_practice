package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_10469 {

    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        boolean flag = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j] == '*') {
                    cnt++;
                    if(!check(i, j)) {
                        flag = false;
                    }
                }
            }
        }

        System.out.println(flag && cnt == 8 ? "valid" : "invalid");
    }

    static boolean check(int x, int y) {

        // 오른쪽
        for (int i = y + 1; i < 8; i++) {
            if (board[x][i] == '*') return false;
        }

        // 아래
        for (int i = x + 1; i < 8; i++) {
            if (board[i][y] == '*') return false;
        }

        // 오아래
        for (int i = 1; i < 8; i++) {
            if (!isPossible(x + i, y + i)) break;
            if (board[x + i][y + i] == '*') return false;
        }

        // 오위
        for (int i = 1; i < 8; i++) {
            if (!isPossible(x - i, y + i)) break;
            if (board[x - i][y + i] == '*') return false;
        }

        return true;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < 8) && (0 <= y && y < 8);
    }
}
