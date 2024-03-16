package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_31459 {
    static int N, M, X, Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int res;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            int[][] board = new int[N][M];
            res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1)
                        continue;

                    board[i][j] = 1;
                    if (isPossible(i, j)) {
                        board[i + X][j + Y] = 1;
                    }

                    res++;
                }
            }
            sb.append(res + "\n");
        }
        System.out.print(sb);
    }

    static boolean isPossible(int x, int y) {
        return (0 <= X + x && X + x < N) && (0 <= Y + y && Y + y < M);
    }
}
