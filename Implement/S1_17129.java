package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_17129 {

    static int N, M, res;
    static int[][] board;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visit = new boolean[N][M];

        String s;
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            s = br.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';

                if (board[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        res = 0;
        bfs(x, y);

        if (res == 0) {
            System.out.print("NIE");
        } else {
            System.out.println("TAK");
            System.out.print(res);
        }
    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { i, j, 0 });

        visit[i][j] = true;

        int x, y;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            x = now[0];
            y = now[1];

            if (board[x][y] > 2) {
                res = now[2];
                return;
            }

            int nx, ny;
            for (int a = 0; a < 4; a++) {
                nx = x + moves[a][0];
                ny = y + moves[a][1];

                if (!isPossible(nx, ny) || visit[nx][ny])
                    continue;
                if (board[nx][ny] == 1)
                    continue;
                visit[nx][ny] = true;
                q.offer(new int[] { nx, ny, now[2] + 1 });
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
