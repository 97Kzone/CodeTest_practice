package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_7576 {
    static int M, N, res;
    static int[][] board;
    static ArrayList<int[]> tmt;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tmt = new ArrayList<>();
        board = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) tmt.add(new int[] {i, j});
            }
        }

        res = 0;
        check();
        for (int[] r: board) {
            for (int i = 0; i < M; i++) {
                if (r[i] == 0) res = -1;
            }
        }

        System.out.print(res == -1 ? -1 : res);
    }

    static void check() {
        Queue<int[]> q = new ArrayDeque<>();
        for (int[] xy : tmt) q.offer(new int[] {xy[0], xy[1], 1});

        int x, y;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            x = now[0];
            y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + moves[i][0];
                int ny = y + moves[i][1];

                if(!isPossible(nx, ny)) continue;
                if(board[nx][ny] != 0) continue;

                board[nx][ny] = now[2] + 1;
                res = Math.max(res, now[2]);
                q.offer(new int[] {nx, ny, now[2] + 1});
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
