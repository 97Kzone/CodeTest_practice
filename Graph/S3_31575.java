package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_31575 {

    static int N, M;
    static int[][] board;
    static int[][] moves = {{1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean res = check();
        System.out.print(res ? "Yes" : "No");
    }

    static boolean check() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});

        boolean[][] visit = new boolean[N][M];
        visit[0][0] = true;

        int[] now;

        int x, y, nx, ny;
        while(!q.isEmpty()) {
            now = q.poll();
            x = now[0];
            y = now[1];
            
            if(x == N-1 && y == M-1) return true;

            for (int[] move : moves) {
                nx = x + move[0];
                ny = y + move[1];

                if (!isPossible(nx, ny)) continue;
                if (board[nx][ny] == 0 || visit[nx][ny]) continue;

                visit[nx][ny] = true;
                q.offer(new int[] {nx, ny});
            }
        }

        return false;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
