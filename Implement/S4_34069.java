package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S4_34069 {

    static int N, M;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if ((N * M) % 2 == 1) {
            bw.write("No");
        } else {
            bw.write("Yes\n");

            // 짝수 기준으로
            if (N % 2 == 0) {
                for (int i = 0; i < N; i += 2) {
                    for (int j = 0; j < M; j++) {
                        bw.write(board[i+1][j] + " ");
                    } 
                    bw.write("\n");
                    for (int j = 0; j < M; j++) {
                        bw.write(board[i][j] + " ");
                    }
                    bw.write("\n");
                }
            } else {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M - 1; j += 2) {
                        bw.write(board[i][j + 1] + " ");
                        bw.write(board[i][j] + " ");
                    }
                    bw.write("\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
