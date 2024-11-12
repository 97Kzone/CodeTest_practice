package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_30648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(br.readLine());

        boolean[][] board = new boolean[R][R];
        board[a][b] = true;

        int res = 0;
        while (true) {
            res++;

            if (a + b + 2 < R) {
                a++;
                b++;
            } else {
                a /= 2;
                b /= 2;
            }

            if (board[a][b]) break;

            board[a][b] = true;
        }
        
        System.out.print(res);
    
    }
}
