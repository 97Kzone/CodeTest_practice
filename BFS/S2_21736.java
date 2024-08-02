package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_21736 {

    static int N, M, res;
    static String[][] board;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];

        int sx = 0;
        int sy = 0;
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if ("I".equals(board[i][j])) {
                    sx = i;
                    sy = j;
                }
            }
        }

        check(sx, sy);
        System.out.print(res == 0 ? "TT" : res);
    }
    
    static void check(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];

        q.offer(new int[] { i, j });
        visit[i][j] = true;

        int[] now;
        int x, y, nx, ny;
        while (!q.isEmpty()) {
            now = q.poll();
            x = now[0];
            y = now[1];
            if ("P".equals(board[x][y])) {
                res++;
            }

            for (int[] move : moves) {
                nx = x + move[0];
                ny = y + move[1];

                if (!isPossible(nx, ny) || visit[nx][ny])
                    continue;

                if ("X".equals(board[nx][ny]))
                    continue;

                q.offer(new int[] { nx, ny });
                visit[nx][ny] = true;
            }
        }
    }
    
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
