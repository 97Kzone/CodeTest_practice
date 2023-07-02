package PG_Level2;

import java.util.*;

class Solution {
    
    static int res, N, M;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[] start, end;
    static char[][] map;
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        res = -1;
        
        // 1. 전처리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = board[i].charAt(j);
                
                if('R' == map[i][j]) start = new int[] {i, j};
                else if ('G' == map[i][j]) end = new int[] {i, j};
            }
        } 
        
        // 2. 탐색
        check();
        
        return res;
    }
    
    static void check() {
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[] {start[0], start[1], 0});        
        
        boolean[][] visit = new boolean[N][M];
        visit[start[0]][start[1]] = true;
    
        int x, y, nx, ny;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            x = now[0];
            y = now[1];
            
            // 종료 조건
            if (x == end[0] && y == end[1]) {
                res = now[2];
                return;
            }
            
            // 한 쪽 방향으로 벽을 만날 때 까지 전진
            nx = x;
            ny = y;
            for (int[] move : moves) {
                nx = x;
                ny = y; 
                
                while(true) {
                    nx += move[0];
                    ny += move[1];
                    
                    // 이번 칸이 맵을 벗어 났으면 그 전 칸이 들어가야한다
                    if (!isPossible(nx, ny) || map[nx][ny] == 'D') {
                        nx -= move[0];
                        ny -= move[1];
                        
                        if (!visit[nx][ny]) {
                            q.offer(new int[] {nx, ny, now[2] + 1});
                            visit[nx][ny] = true;
                        }
                                                                    
                        break;
                    }
                    
                    
                }
            }
        }
    }
    
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}