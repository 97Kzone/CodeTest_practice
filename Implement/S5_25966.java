package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_25966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        int a, b, c, d;
        int[] tmp;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == 0) {
                d = Integer.parseInt(st.nextToken());

                board[b][c] = d;
            } else {
                tmp = board[b];
                board[b] = board[c];
                board[c] = tmp;
            }
        }
        
        for (int[] nums : board) {
            for (int num : nums) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
