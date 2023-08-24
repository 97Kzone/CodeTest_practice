import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] board;
    static List<Integer> res;
    static int[] visit;
    static int N;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        N = n;
        board = new ArrayList[n+1];
        res = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) board[i] = new ArrayList<>();
        
        int s, e;
        for (int[] road : roads) {
            s = road[0];
            e = road[1];
            
            board[s].add(e);
            board[e].add(s);
        }
        
        bfs(destination);
        
        s = 0;
        for (int v : sources) answer[s++] = visit[v];
 
        return answer;
    }
    
    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque();
        q.offer(start);
        
        visit = new int[N+1];
        Arrays.fill(visit, -1);
        visit[start] = 0;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for (int nxt : board[now]) {
                if (visit[nxt] == -1) {
                    q.offer(nxt);
                    visit[nxt] = visit[now] + 1;
                }   
            }
        }
        
        res.add(-1);
    } 
}