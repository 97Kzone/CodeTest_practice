package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_23793 {

    static int N, M;
    static int x, y, z;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int s, e, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[s].add(new int[] { e, v });
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());

        long v1 = check(x, y, 0);
        long v2 = check(y, z, 0);
        long v3 = check(x, z, 1);
        
        long res1;
        if (v1 == Integer.MAX_VALUE || v2 == Integer.MAX_VALUE) res1 = -1;
        else res1 = v1 + v2;
        long res2 = v3 == Integer.MAX_VALUE ? -1 : v3;

        System.out.print(res1 + " " + res2);
    }

    static long check(int a, int b, int flag) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new int[] { a, 0 });
        dist[a] = 0;
        
        int[] now;
        while (!pq.isEmpty()) {
            now = pq.poll();

            if (dist[now[0]] < now[1]) continue;
            for (int[] nxt : graph[now[0]]) {
                
                if (flag == 1) {
                    if (nxt[0] == y)
                        continue;
                }
                
                if (dist[nxt[0]] < dist[now[0]] + nxt[1]) continue;
                
                dist[nxt[0]] = dist[now[0]] + nxt[1];
                pq.offer(new int[] { nxt[0], dist[nxt[0]] });
            }
        }

        return dist[b];
    }
}
