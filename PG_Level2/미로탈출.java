package PG_Level2; 

import java.util.*;

// 1. 시작 ~ 레버 까지 1회
// 2. 레버 ~ 끝 까지 1회
// 3. 총 2번 BFS 탐색으로 해결 해보자
class Solution {

    static int[] start, end, lever;
    static char[][] board;
    static int N, M;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        board = new char[N][M];

        String s;
        for (int i = 0; i < N; i++) {
            s = maps[i];
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j); 

                if (board[i][j] == 'S') start = new int[] {i, j};
                else if (board[i][j] == 'E') end = new int[] {i, j};
                else if (board[i][j] == 'L') lever = new int[] {i, j};
            } 
        }

        int res1 = check(start, lever);
        int res2 = check(lever, end);

        if (res1 == 0 || res2 == 0) return -1;
        else return res1 + res2;
    }

    static int check(int[] s, int[] e) {
        Queue<int[]> q = new ArrayDeque();
        boolean[][] visit = new boolean[N][M];

        q.offer(new int[] {s[0], s[1], 0});
        visit[s[0]][s[1]] = true;

        int x, y;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            x = now[0];
            y = now[1];

            if (x == e[0] && y == e[1]) return now[2];

            int nx, ny;
            for (int[] move : moves) {
                nx = x + move[0];
                ny = y + move[1];

                if (!isPossible(nx, ny) || visit[nx][ny]) continue;
                if (board[nx][ny] == 'X') continue;

                q.offer(new int[] {nx, ny, now[2] + 1});
                visit[nx][ny] = true;
            }
        }

        return 0;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}