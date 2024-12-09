package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_18242 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (flag)
                break;
            for (int j = 0; j < M; j++) {
                if (board[i][j] != '#')
                    continue;

                x1 = i;
                y1 = j;
                flag = true;
                break;
            }
        }
        flag = false;
        for (int i = N - 1; i >= 0; i--) {
            if (flag)
                break;
            for (int j = M - 1; j >= 0; j--) {
                if (board[i][j] != '#')
                    continue;

                x2 = i;
                y2 = j;
                flag = true;
                break;
            }
        }
        
        int mx = (x1 + x2) / 2;
        int my = (y1 + y2) / 2;

        if (board[x1][my] == '.') {
            System.out.print("UP");
        } else if (board[mx][y1] == '.') {
            System.out.print("LEFT");
        } else if (board[x2][my] == '.') {
            System.out.print("DOWN");
        } else if (board[mx][y2] == '.') {
            System.out.print("RIGHT");
        }
    }
}
