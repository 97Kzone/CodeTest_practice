package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S5_12759 {
    
    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }

        char cmd;
        int x, y;
        int player = N;
        int winner = 0;
        while(true) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            cmd = player == 1 ? 'O' : 'X';
            board[x - 1][y - 1] = cmd;

            winner = check();
            if (winner > 0)
                break;

            boolean draw = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        draw = false;
                        break;
                    }
                }
                if (!draw) break;
            }

            if (draw) {
                winner = 3; 
                break;
            }

            player = (player == 1) ? 2 : 1;
        }
        
        System.out.print(winner < 3 ? winner : 0);
    }

    static int check() {
        List<char[]> list = new ArrayList<>();
        int win = 0;
        for (int i = 0; i < 3; i++) {
            list.add(new char[] { board[i][0], board[i][1], board[i][2] });
            list.add(new char[] { board[0][i], board[1][i], board[2][i] });
        }

        list.add(new char[] { board[0][0], board[1][1], board[2][2] });
        list.add(new char[] { board[0][2], board[1][1], board[2][0] });

        for (char[] std : list) {
            if (std[0] == 'O' && std[1] == 'O' && std[2] == 'O') {
                win = 1;
            }

            if (std[0] == 'X' && std[1] == 'X' && std[2] == 'X') {
                win = 2;
            }
        }
        
        return win;
    }
}
