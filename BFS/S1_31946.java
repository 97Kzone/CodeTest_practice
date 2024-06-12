package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_31946 {

    static int N, M, X, std;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        X = Integer.parseInt(br.readLine());
        std = board[0][0];

        boolean flag = check();
        System.out.print(flag ? "ALIVE" : "DEAD");
    }
    
    static boolean check() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0 });
        board[0][0] = -1;

        int[] now;
        int x, y;
        while (!q.isEmpty()) {
            now = q.poll();

            x = now[0];
            y = now[1];

            if (x == N - 1 && y == M - 1) {
                return true;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == -1) continue;
                    if (std != board[i][j]) continue;
                    if (Math.abs(i - x) + Math.abs(j - y) > X) continue;

                    q.offer(new int[] { i, j });
                    board[i][j] = -1;
                }
            }
        }
        return false;
    }
}
