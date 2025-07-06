package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_3097 {

    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][2];

        int sumX = 0, sumY = 0;
        int x, y;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            board[i][0] = x;
            board[i][1] = y;

            sumX += x;
            sumY += y;
        }

        double res = 10000000;

        for (int i = 0; i < N; i++) {
            x = sumX - board[i][0];
            y = sumY - board[i][1];
            
            res = Math.min(res, Math.sqrt((x * x) + (y * y)));
        }

        System.out.println(sumX + " " + sumY);
        System.out.printf("%.2f", res);
    }
}