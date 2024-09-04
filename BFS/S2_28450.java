package BFS;

import java.util.*;
import java.io.*;

public class S2_28450 {

    static int N, M, H;
    static long[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new long[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Long.parseLong(st.nextToken());
            }
        }

        init();

        H = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                board[i][j] += Math.min(board[i][j - 1], board[i - 1][j]);
            }
        }

        if (board[N][M] > H) {
            System.out.print("NO");
        } else {
            System.out.println("YES");
            System.out.print(board[N][M]);
        }
    }
    
    static void init() {
        for (int i = 1; i <= N; i++) {
            board[i][1] += board[i - 1][1];
        }

        for (int i = 1; i <= M; i++) {
            board[1][i] += board[1][i - 1];
        }
    }
}
