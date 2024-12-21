package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_14732 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int maxX = 0;
        int maxY = 0;
        int minX = 500;
        int minY = 500;
        
        boolean[][] board = new boolean[501][501];

        int cnt = 0;
        int x1, x2, y1, y2;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    board[x][y] = true;
                }
            }
        }

        for (int i = minX; i < maxX; i++) {
            for (int j = minY; j < maxY; j++) {
                if (board[i][j])
                    cnt++;
            }
        }

        System.out.print(cnt);
    }
}
