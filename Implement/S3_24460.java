package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_24460 {

    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = check(N, 0, 0);
        System.out.print(res);
    }
    
    static int check(int n, int x, int y) {
        if (n == 1) return board[x][y];

        int[] tmp = new int[] {
            check(n/2 ,x ,y),
            check(n/2, x, y + n/2),
            check(n/2 , x+ n/2, y),
            check(n/2, x + n/2, y + n/2)
        };
        Arrays.sort(tmp);

        return tmp[1];
    }

}
