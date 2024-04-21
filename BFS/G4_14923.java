package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_14923 {

    static int N, M, Hx, Hy, Ex, Ey;
    static int[][] board;
    static boolean[][][] visit;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken()) - 1;
        Hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken()) - 1;
        Ey = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = check();
        System.out.print(res == Integer.MAX_VALUE ? -1 : res);
    }
    
    static int check() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[3] - o2[3]));
        pq.offer(new int[] { Hx, Hy, 0, 0 });

        visit = new boolean[N][M][2];
        visit[Hx][Hy][0] = true;

        int[] now;
        int nx, ny;
        while (!pq.isEmpty()) {
            now = pq.poll();
            if (now[0] == Ex && now[1] == Ey) {
                return now[3];
            }

            for (int[] move : moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];

                if (!isPossible(nx, ny) || visit[nx][ny][now[2]]) continue;
                if (board[nx][ny] == 0) {
                    visit[nx][ny][now[2]] = true;
                    pq.offer(new int[] { nx, ny, now[2], now[3] + 1});
                } else if (board[nx][ny] == 1 && now[2] == 0) {
                    visit[nx][ny][1] = true;
                    pq.offer(new int[] { nx, ny, 1, now[3] + 1 });
                }
                
            }
        }
        
        return Integer.MAX_VALUE;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
