package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_13565 {

    static int N, M;
    static int[][] board;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        String[] s;
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        String res = "NO";
        for (int i = 0; i < M; i++) {
            if (board[0][i] != 1) {
                if (check(0, i)) {
                    res = "YES";
                    break;
                }
            }
        }
        
        System.out.print(res);
    }

    static boolean check(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];

        q.offer(new int[] { x, y });
        visit[x][y] = true;

        int[] now;
        int nx, ny;
        while (!q.isEmpty()) {
            now = q.poll();

            if (now[0] == N - 1)
                return true;

            for (int[] move : moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];

                if (!isPossible(nx, ny) || visit[nx][ny])
                    continue;
                if (board[nx][ny] == 1)
                    continue;

                q.offer(new int[] { nx, ny });
                visit[nx][ny] = true;
            }
        }

        return false;
    }
    
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
