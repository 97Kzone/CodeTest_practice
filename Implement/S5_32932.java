package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_32932 {
    static int N, K;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[1001][1001];

        int x, y;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            board[x + 500][y + 500] = -1;
        }
        
        int nx = 500;
        int ny = 500;
        char[] cmd = br.readLine().toCharArray();
        for (char c : cmd) {
            if (c == 'U') {
                if (board[nx][ny + 1] != -1) {
                    ny++;
                }
            } else if (c == 'D') {
                if (board[nx][ny - 1] != -1) {
                    ny--;
                }
            } else if (c == 'R') {
                if (board[nx + 1][ny] != -1) {
                    nx++;
                }
            } else if (c == 'L') {
                if (board[nx - 1][ny] != -1) {
                    nx--;
                }
            }
        }

        System.out.print((nx-500) + " " + (ny-500));
    }
}
