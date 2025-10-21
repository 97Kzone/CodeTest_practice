package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class S5_33938 {
    static int N, M;
    static int[] coins;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        if (M == 0) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            return;
        }
        
        if (N == 0) {
            bw.write("-1\n");
            bw.flush();
            bw.close();
            return;
        }
        
        coins = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = check();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
    
    static int check() {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        
        q.offer(new int[]{0, 0});
        visit.add(0);
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int cnt = cur[1];
            
            if (x == M) return cnt;
            
            for (int coin : coins) {
                int nx = x + coin;
                
                if (nx < -1000 || nx > 1000) continue;
                if (visit.contains(nx)) continue;
                
                visit.add(nx);
                q.offer(new int[]{nx, cnt + 1});
            }
        }
        
        return -1;
    }
}