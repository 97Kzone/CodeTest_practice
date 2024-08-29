package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_29718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 1
        for (int j = 0; j < M; j++) {
            for (int i = 1; i < N; i++) {
                board[i][j] += board[i - 1][j];
            }
        }

        // 누적합 2
        for (int j = 1; j < M; j++) {
            board[N - 1][j] += board[N - 1][j - 1];
        }

        int A = Integer.parseInt(br.readLine());
        int res = board[N - 1][A - 1];
        
        for (int i = A; i < M; i++) {
            res = Math.max(res, board[N - 1][i] - board[N - 1][i - A]);
        }
        System.out.print(res);
        
    }
}
