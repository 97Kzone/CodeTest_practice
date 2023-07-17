package PG_Level1;

import java.util.*;

class Solution {
    
    static int w, h, x, y;
    static int[][] moves = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // 상, 좌, 하, 우
    static String[][] board;
    static Map<String, Integer> maps;
    
    public int[] solution(String[] park, String[] routes) {
        init(park);
        
        String op, tmp[];
        int n, dx, dy;
        boolean flag;
        
        for (String r : routes) {
            tmp = r.split(" ");
            op = tmp[0];
            n = Integer.parseInt(tmp[1]);

            int m = maps.get(op);
            dx = moves[m][0];
            dy = moves[m][1];
            
            
            // N번 이동이 가능한지 체크
            int nx = x;
            int ny = y;
            flag = true;
            for (int i = 0; i < n; i++) {
                nx += dx;
                ny += dy;
                
                if (!isPossible(nx, ny)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                x = nx;
                y = ny;
            }
        }
        
        return new int[] {x, y};
    }
    
    static boolean isPossible(int x, int y) {
        if (x < 0 || x >= w || y < 0 || y >= h) return false;
        if("X".equals(board[x][y])) return false;
        return true;
    }
    
    // 초기 설정
    static void init(String[] park) {
        w = park[0].length();
        h = park.length;
        board = new String[h][w];
        
        for (int i = 0; i < h; i++) {
            board[i] = park[i].split("");
            
            for (int j = 0; j < w; j++) {
                if ("S".equals(board[i][j])) {
                    x = i;
                    y = j;
                }
            }
        }
        
        maps = new HashMap<>();
        maps.put("N", 0);
        maps.put("W", 1);
        maps.put("S", 2);
        maps.put("E", 3);
    }
        
}