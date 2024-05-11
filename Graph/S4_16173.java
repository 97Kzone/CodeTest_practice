package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S4_16173 {
    
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean res = check();

        if (res) {
            System.out.print("HaruHaru");
        } else {
            System.out.print("Hing");
        }
    }
    
    static boolean check() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];

        q.offer(new int[] { 0, 0 });
        visit[0][0] = true;

        int x, y, nx, ny;
        int[] now;
        while (!q.isEmpty()) {
            now = q.poll();
            x = now[0];
            y = now[1];
            if (x == N - 1 && y == N - 1) {
                return true;
            }

            nx = x + board[x][y];
            ny = y;

            if (isPossible(nx, ny) && !visit[nx][ny]) {
                q.offer(new int[] { nx, ny });
                visit[nx][ny] = true;
            }

            nx = x;
            ny = y + board[x][y];

            if (isPossible(nx, ny) && !visit[nx][ny]) {
                q.offer(new int[] { nx, ny });
                visit[nx][ny] = true;
            }
        }
        
        return false;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}
