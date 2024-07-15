package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_12760 {

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.sort(board[i]);
        }

        int[] wins = new int[N];
        int std;
        for (int j = M - 1; j >= 0; j--) {
            std = 0;
            for (int i = 0; i < N; i++) {
                if (std < board[i][j]) {
                    std = board[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                if (std == board[i][j]) {
                    wins[i]++;
                }
            }
        }

        std = 0;
        for (int i = 0; i < N; i++) {
            if (std < wins[i]) {
                std = wins[i];
            }
        }

        for (int i = 0; i < N; i++) {
            if (std == wins[i]) {
                sb.append((i+1) + " ");
            }
        }

        System.out.print(sb);
    }

}
