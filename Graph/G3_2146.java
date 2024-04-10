package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import PG_Level2.sol;

public class G3_2146 {

    static int N, res;
    static int[][] board, board2;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        board2 = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 각 그래프 영역 나누기
        int idx = 1;
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 || visit[i][j])
                    continue;

                check(i, j, idx++);
            }
        }

        // 2. 모든 영역을 순회하면서 최단거리 찾기..
        res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board2[i][j] == 0)
                    continue;

                res = Math.min(res, findPath(i, j));
            }
        }

        System.out.print(res);
    }
    
    static int findPath(int i, int j) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        pq.offer(new int[] { i, j, 0 });
        visit = new boolean[N][N];
        visit[i][j] = true;

        int std = board2[i][j];
        int[] now;
        int x, y, nx, ny;
        while (!pq.isEmpty()) {
            now = pq.poll();
            x = now[0];
            y = now[1];
            if (board2[x][y] != 0 && board2[x][y] != std) {
                return now[2] - 1;
            }

            for (int[] move : moves) {
                nx = x + move[0];
                ny = y + move[1];

                if (!isPossible(nx, ny) || visit[nx][ny]) continue;
                if (board2[nx][ny] == std) continue;

                visit[nx][ny] = true;
                pq.offer(new int[] { nx, ny, now[2] + 1 });
            }
        }

        return Integer.MAX_VALUE;
    }

    static void check(int i, int j, int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { i, j });
        visit[i][j] = true;

        board2[i][j] = idx;
        int[] now;
        int nx, ny;
        while (!q.isEmpty()) {
            now = q.poll();

            for (int[] move : moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];

                if (!isPossible(nx, ny) || visit[nx][ny]) continue;
                if (board[nx][ny] == 0) continue;
                
                visit[nx][ny] = true;
                board2[nx][ny] = idx;
                q.offer(new int[] { nx, ny });
            }
        }
    }
    
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}
