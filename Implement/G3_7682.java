package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class G3_7682 {
    static String[] board;
    static String res;
    static int cx, co;
    public static void main(String[] args) throws IOException {
        sol();
    }

    static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while (true) {
            s = br.readLine();
            if (s.equals("end")) break;

            board = s.split("");
            res = "invalid";         

            cx = Collections.frequency(Arrays.asList(board), "X");
            co = Collections.frequency(Arrays.asList(board), "O");

            if(isWin()) res = "valid";
            System.out.println(res);
        }
    }

    static boolean isWin() {
        int x = 0, o = 0;
        if (cx - co != 1 && cx - co != 0) return false;

        //가로체크
        for (int i = 0; i < 9; i+=3) {
            if (board[i].equals(".")) continue;
            if (board[i].equals(board[i+1]) && board[i+1].equals(board[i+2])) {
                if (board[i].equals("X")) {
                    x++;
                } else o++;
            }
        }

        //세로체크
        for (int i = 0; i < 3; i++) {
            if (board[i].equals(".")) continue;
            if (board[i].equals(board[i+3]) && board[i+3].equals(board[i+6])) {
                if (board[i].equals("X")) {
                    x++;
                } else o++;
            }
        }

        //대각체크
        if (!board[4].equals(".")) {
            if ((board[0].equals(board[4]) && board[4].equals(board[8])) || 
            (board[2].equals(board[4]) && board[4].equals(board[6]))) {
                if (board[4].equals("X")) {
                    x++;
                } else o++;
            }
        }

        if (x > 0) {
            if (o > 0) return false;
            if (cx - co == 1) return true;
            return false;
        }
        if (o > 0) {
            if (cx == co) return true;
            return false;
        }
        if (cx + co == 9) return true;
        return false;
    }
}
