package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_18223 {

    static int V, E, P;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        int s, e, v;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[s].add(new int[] {e, v});
            graph[e].add(new int[] {s, v});
        }

        int res1 = check(1, P);
        int res2 = check(P, V);
        int res3 = check(1, V);

        System.out.print(res1 + res2 == res3 ? "SAVE HIM" : "GOOD BYE");
    }

    static int check(int s, int e) {
        boolean[] visit = new boolean[V+1];
        int[] dist = new int[V+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        pq.offer(new int[] {s, 0});

        int[] now;
        int idx, v;
        while(!pq.isEmpty()) {
            now = pq.poll();

            idx = now[0];
            v = now[1];
            if(visit[idx]) continue;
            visit[idx] = true;

            for (int[] nxt : graph[idx]) {
                if (dist[nxt[0]] > dist[idx] + nxt[1]) {
                    dist[nxt[0]] = dist[idx] + nxt[1];
                    pq.offer(new int[] {nxt[0], dist[nxt[0]]});
                }
            }
        }

        return dist[e];
    }
}
