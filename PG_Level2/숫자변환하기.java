package PG_Level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 숫자변환하기 {
    static boolean[] visit;
    
    public int solution(int x, int y, int n) {
        visit = new boolean[y+1];        
        
        return check(x, y, n);
    }
    
    static int check(int x, int y, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, 0});
        
        visit[x] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            if (now[0] == y) return now[1];
            
            int nxt = now[0] + n;
            // 1. N 더하기
            if (nxt <= y && !visit[nxt]) {
                q.offer(new int[] {nxt, now[1] + 1});
                visit[nxt] = true;
            } 
            
            nxt = now[0] * 2;
            // 2. 2 곱하기
            if (nxt <= y && !visit[nxt]) {
                q.offer(new int[] {nxt, now[1] + 1});
                visit[nxt] = true;
            }
            
            nxt = now[0] * 3;
            // 3. 3 곱하기
            if (now[0] * 3 <= y && !visit[nxt]) {
                q.offer(new int[] {nxt, now[1] + 1});
                visit[nxt] = true;
            }
        }
        return -1;
    }
}
