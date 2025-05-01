package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_24445 {

    static int N, M, R;
    static PriorityQueue<Integer>[] graph;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new PriorityQueue[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        }

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph[s].offer(e);
            graph[e].offer(s);
        }

        nums = new int[N+1];
        check();
        
        for (int i = 1; i <= N; i++) {
            sb.append(nums[i] + "\n");
        }

        System.out.print(sb.toString());

    }

    static void check() {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[N+1];
        visit[R] = true;
        q.offer(R);
        
        int cnt = 1;
        nums[R] = cnt++;
        int now;
        while(!q.isEmpty()) {
            now = q.poll();

            while (!graph[now].isEmpty()) {
                int nxt = graph[now].poll(); 
                if (visit[nxt]) continue;
    
                visit[nxt] = true;
                q.offer(nxt);
                nums[nxt] = cnt++;
            }
        }
    }
}
