package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_24419 {

    static int N;
    static long res1, res2;
    static int[][] board;
    static int std = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        res2 = N * N;

        board = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res1 = check() + 1;
        System.out.println(res1 + " " + res2);
    }

    static long check() {
        long[][] cnt = new long[N+1][N+1];

        long v1, v2;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 1 && j == 1) {
                    cnt[i][j] = 1;
                    continue;
                } 

                v1 = i > 1 ? cnt[i-1][j] : 0;
                v2 = j > 1 ? cnt[i][j-1] : 0;
                cnt[i][j] = (v1 + v2 + 1) % std;
            }
        }

        return cnt[N][N];
    }
}
