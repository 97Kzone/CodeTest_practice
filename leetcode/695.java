package leetcode;

import java.util.*;

class Solution {

    static int N, M;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] board;

    public int maxAreaOfIsland(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        board = grid;

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    res = Math.max(res, check(i, j));
                }
            }
        }     

        return res;
    }

    static int check(int x, int y) {
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[] {x, y});
        board[x][y] = 0;
        int[] now;
        int cnt = 1;
        int nx, ny;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int[] move : moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];

                if(!isPossible(nx, ny)) continue;
                if(board[nx][ny] == 0) continue;

                board[nx][ny] = 0;
                cnt++;
                q.offer(new int[] {nx, ny});
            }
        }

        return cnt;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}