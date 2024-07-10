package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S4_31714 {

    static int N, M, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < M; j++) {
                board[i][j] = pq.poll() + (i * D);

                if (i != 0 && board[i][j] <= board[i - 1][j]) {
                    System.out.print("NO");
                    return;
                }
            }
        }
        
        System.out.print("YES");
    }
}
