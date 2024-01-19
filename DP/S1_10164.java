package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_10164 {

    static int N, M, K;
    static int[][] board;
    static int[][] moves = { { 0, 1 }, { 1, 0 } };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        int idx = 1;
        int tx = K != 0 ? K / N : 0;
        int ty = K != 0 ? K % M : 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = idx++;
            }
        }

        if (tx != 0 && ty != 0) {
            int res1 = check(0, 0, tx - 1, ty - 1);
            int res2 = check(tx - 1, ty - 1, N - 1, M - 1);

            System.out.println(res1 * res2);
        } else {
            int res = check(0, 0, N - 1, M - 1);
            System.out.print(res);
        }
    }
    
    static int check(int sx, int sy, int tx, int ty) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sx, sy});

        int[] now;
        int nx, ny;
        int res = 0;
        while (!q.isEmpty()) {
            now = q.poll();

            if (now[0] == tx && now[1] == ty) {
                res++;
                continue;
            }

            for (int[] move : moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];

                if (!isPossible(nx, ny))
                    continue;

                q.offer(new int[] { nx, ny });
            }
        }
        return res;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
