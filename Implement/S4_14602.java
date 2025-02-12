package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S4_14602 {

    static int N, M, K, W;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        board = new int[M+1][N+1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> list = new ArrayList<>();
        int std1 = M - W + 1;
        int std2 = N - W + 1;
        int idx = W * W / 2;

        for (int i = 1; i <= std1; i++) {
            for (int j = 1; j <= std2; j++) {
                list = new ArrayList<>();

                for (int x = 0; x < W; x++) {
                    for (int y = 0; y < W; y++) {
                        list.add(board[i + x][j + y]);
                    }
                }

                Collections.sort(list);
                sb.append(list.get(idx) + " ");
            }

            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
