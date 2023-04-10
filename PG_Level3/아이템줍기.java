package PG_Level3;

import java.util.*;

public class 아이템줍기 {
    static int[][] board; // 전체 맵
    static boolean[][] visit;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int cx, cy, ix, iy;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        board = new int[102][102];
        
        // 사각형 맵에 전체 덮기
        for (int[] xy : rectangle) cover(xy);
        
        // 사각형 테두리만 남기고 전체 밀기
        for (int[] xy : rectangle) uncover(xy);
        
        cx = characterX * 2;
        cy = characterY * 2;
        ix = itemX * 2;
        iy = itemY * 2;
        
        visit = new boolean[102][102];
        
        return bfs(cx, cy);
    }
    
    static int bfs(int a, int b) {
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[] {a, b, 0});
        visit[a][b] = true;
        
        int x, y, cnt;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            x = now[0];
            y = now[1];
            cnt = now[2];
            
            if (x == ix && y == iy) return cnt / 2;
            
            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = x + moves[i][0];
                ny = y + moves[i][1];
                
                if (board[nx][ny] == 1 && !visit[nx][ny]) {
                    q.offer(new int[] {nx, ny, cnt + 1});
                    visit[nx][ny] = true;
                }
            }
        }
        
        return 0;
    }
    
    // 사각형을 맵에 표현
    static void cover(int[] xy) {
        int x1 = xy[0];
        int y1 = xy[1];
        int x2 = xy[2];
        int y2 = xy[3];
        
        for (int i = x1 * 2; i <= x2 * 2; i++) {
            for (int j = y1 * 2; j <= y2 * 2; j++) {
                board[i][j] = 1;
            }
        }
    }
    
    // 테두리 남기고 밀기
    static void uncover(int[] xy) {
        int x1 = xy[0];
        int y1 = xy[1];
        int x2 = xy[2];
        int y2 = xy[3];
        
        for (int i = x1 * 2 + 1 ; i < x2 * 2; i++) {
            for (int j = y1 * 2 + 1; j < y2 * 2; j++) {
                board[i][j] = 0;
            }
        }
    }
}
