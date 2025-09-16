package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S4_12335 {

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            board = new char[4][4];

            boolean flag = true; // 게임 결과 여부

            for (int i = 0; i < 4; i++) {
                board[i] = br.readLine().toCharArray();

                for (int j = 0; j < 4; j++) {
                    if (board[i][j] == '.') flag = false;
                }
            }

            boolean winX = check('X');
            boolean winO = check('O');

            String res;
            if (winX) res = "O won";
            else if (winO) res = "X won";
            else if (flag) res = "Draw";
            else res = "Game has not completed";

            bw.write("Case #" + t + ": " + res + "\n");
            if(t != T) br.readLine();
        }

        bw.flush();
        bw.close();
    }

    static boolean check(char std) {
        boolean res;
        
        for (int i = 0; i < 4; i++) {
            res = true;
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == '.' || board[i][j] == std) res = false;
            }

            if (res) return true;
        }

        for (int j = 0; j < 4; j++) {
            res = true;
            for (int i = 0; i < 4; i++) {
                if (board[i][j] == '.' || board[i][j] == std) res = false;
            }
            if (res) return true;
        }

        res = true;
        for (int i = 0; i < 4; i++) {
            if (board[i][i] == '.' || board[i][i] == std) res = false;
        }
        if (res) return res;

        res = true;
        for (int i = 0; i < 4; i++) {
            if (board[i][3 - i] == '.' || board[i][3 - i] == std) res = false;
        }
        if (res) return res;

        return false;
    }
}
