package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_30106 {

    static int N, M, K;
    static int[][] board;
    static boolean[][] visit;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) continue;

                check(i, j);
                res++;
            }
        }

        System.out.print(res);
    }

    static void check(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        
        visit[x][y] = true;

        int[] now;
        int nx, ny;
        while(!q.isEmpty()) {
            now = q.poll();
            x = now[0];
            y = now[1];
            for (int[] move : moves) {
                nx = x + move[0];
                ny = y + move[1];

                if (!isPossible(nx, ny)) continue;
                if (visit[nx][ny]) continue;
                if (Math.abs(board[x][y] - board[nx][ny]) > K) continue;

                visit[nx][ny] = true;
                q.offer(new int[] {nx, ny});
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
