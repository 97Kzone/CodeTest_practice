package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_16955 {

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[10][10];
        for (int i = 0; i < 10; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int res = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'X';
                    if (check()) {
                        res = 1;
                        break;
                    }

                    board[i][j] = '.';
                }
            }
        }

        System.out.print(res);
    }
    
    static boolean check() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 'X') {
                    // 1. 가로 체크
                    if (j <= 5) {
                        if (board[i][j + 1] == 'X' && board[i][j + 2] == 'X' && board[i][j + 3] == 'X' && board[i][j + 4] == 'X') {
                            return true;
                        }
                    }
                    
                    // 2. 세로체크
                    if (i <= 5) {
                        if (board[i + 1][j] == 'X' && board[i + 2][j] == 'X' && board[i + 3][j] == 'X' && board[i + 4][j] == 'X') {
                            return true;
                        }
                    }
                    
                    // 3. 대각체크 (우하단)
                    if (i <= 5 && j <= 5) {
                        if (board[i + 1][j + 1] == 'X' && board[i + 2][j + 2] == 'X'
                         && board[i + 3][j + 3] == 'X' && board[i + 4][j + 4] == 'X') {
                            return true;
                        }
                    }
                    // 4. 대각체크 (우상단)
                    if (i >= 4 && j <= 5) {
                        if (board[i - 1][j + 1] == 'X' && board[i - 2][j + 2] == 'X'
                                && board[i - 3][j + 3] == 'X' && board[i - 4][j + 4] == 'X') {
                            return true;
                        }
                    }
                    
                    // 5. 대각체크 (좌하단)
                    if (i <= 5 && j >= 4) {
                        if (board[i + 1][j - 1] == 'X' && board[i + 2][j - 2] == 'X'
                         && board[i + 3][j - 3] == 'X' && board[i + 4][j - 4] == 'X') {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
