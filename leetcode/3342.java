package leetcode;

import java.util.*;

class Solution {

    static int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M;
    public int minTimeToReach(int[][] moveTime) {
        N = moveTime.length;
        M = moveTime[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        boolean[][] visit = new boolean[N][M];
        
        pq.offer(new int[] {0, 0, 0, 0}); // x, y, t, cnt

        int[] now;
        int res = 0;
        int nx, ny, t, cnt, std;
        while(!pq.isEmpty()) {
            now = pq.poll();

            t = now[2];
            cnt = now[3];
            std = cnt % 2 == 0 ? 1 : 2;

            if (now[0] == N - 1 && now[1] == M - 1) {
                res = t;
                break;
            }

            for (int[] move : moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];

                if (!isPossible(nx, ny)) continue;
                if (visit[nx][ny]) continue;

                if (moveTime[nx][ny] > t) {
                    pq.offer(new int[] {nx, ny, moveTime[nx][ny] + std, cnt + 1});
                } else {
                    pq.offer(new int[] {nx, ny, t + std, cnt + 1});
                }

                visit[nx][ny] = true;
            }
        }   

        return res;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}