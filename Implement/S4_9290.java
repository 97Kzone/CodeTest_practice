package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_9290 {

    static String std;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            board = new char[3][3];

            for (int i = 0; i < 3; i++) {
                board[i] = br.readLine().toCharArray();
            }

            std = br.readLine();
            char player = std.charAt(0);

            ticTacToe(player);

            sb.append("Case ").append(t).append(":\n");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(board[i][j]);
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }

    static void ticTacToe(char player) {
        int count;

        for (int i = 0; i < 3; i++) {
            count = 0;
            int dash = -1;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == player) count++;
                if (board[i][j] == '-') dash = j;
            }
            if (count == 2 && dash != -1) {
                board[i][dash] = player;
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            count = 0;
            int dash = -1;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == player) count++;
                if (board[j][i] == '-') dash = j;
            }
            if (count == 2 && dash != -1) {
                board[dash][i] = player;
                return;
            }
        }

        count = 0;
        int dashX = -1, dashY = -1;
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == player) count++;
            if (board[i][i] == '-') {
                dashX = i;
                dashY = i;
            }
        }
        if (count == 2 && dashX != -1) {
            board[dashX][dashY] = player;
            return;
        }

        count = 0;
        dashX = -1;
        dashY = -1;
        for (int i = 0; i < 3; i++) {
            if (board[i][2 - i] == player) count++;
            if (board[i][2 - i] == '-') {
                dashX = i;
                dashY = 2 - i;
            }
        }
        if (count == 2 && dashX != -1) {
            board[dashX][dashY] = player;
        }
    }
}
