package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_14284 {

    static int N, M;
    static List<int[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }   

        int s, e, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[s].add(new int[] {e, w});
            graph[e].add(new int[] {s, w});
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        check(s, e);
    }

    static void check(int s, int e) {
        boolean[] visit = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        pq.offer(new int[] {s, 0});

        int[] now;
        while(!pq.isEmpty()) {
            now = pq.poll();

            if (visit[now[0]]) continue;
            visit[now[0]] = true;

            for (int[] nxt : graph[now[0]]) {
                if (dist[nxt[0]] > dist[now[0]] + nxt[1]) {
                    dist[nxt[0]] = dist[now[0]] + nxt[1];
                    pq.offer(new int[] {nxt[0], dist[nxt[0]]});
                }
            }
        }

        System.out.print(dist[e]);
    }
}
