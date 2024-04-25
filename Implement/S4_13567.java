package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_13567 {

    static int M, n;
    static int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;
        int d = 1;
        String com;
        int nx, ny, v;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            com = st.nextToken();
            v = Integer.parseInt(st.nextToken());
            if ("MOVE".equals(com)) {
                nx = x + (moves[d][0] * v);
                ny = y + (moves[d][1] * v);

                if (!isPossible(nx, ny)) {
                    System.out.print(-1);
                    return;
                }
                
                x = nx;
                y = ny;
            } else {
                if (v == 0) d = (d + 3) % 4;
                else d = (d + 1) % 4;
            }
        }
        
        System.out.print(y + " " + x);
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < M) && (0 <= y && y < M);
    }
}
