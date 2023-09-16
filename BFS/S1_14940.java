package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_14940 {

    static int N, M;
    static int[][] board;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        visit = new boolean[N][M];
        bfs(x, y);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j])
                    continue;

                if (board[i][j] != 0) {
                    board[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { x, y, 0 });
        board[x][y] = 0;
        visit[x][y] = true;
        int[] now;

        while (!q.isEmpty()) {
            now = q.poll();

            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = now[0] + moves[i][0];
                ny = now[1] + moves[i][1];

                if (!isPossible(nx, ny) || visit[nx][ny]) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    continue;
                }

                board[nx][ny] = now[2] + 1;
                visit[nx][ny] = true;
                q.offer(new int[] { nx, ny, now[2] + 1 });
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
