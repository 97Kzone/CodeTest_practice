package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_18352 {

    static int N, M, K, X;
    static List<Integer>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) graph[i] = new ArrayList<>();
        dist = new int[N + 1];
        
        Arrays.fill(dist, 100000000);
        dist[X] = 0;

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
        }

        check();

        
        for (int i = 1; i <= N; i++) {
            if (dist[i] != K) continue;
            sb.append(i + "\n");
        }
        
        System.out.print(sb.length() != 0 ? sb : "-1");
    }
    
    static void check() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { X, 0 });

        int[] now;
        while (!q.isEmpty()) {
            now = q.poll();

            for (int nxt : graph[now[0]]) {
                if (dist[nxt] < now[1] + 1) continue;
                dist[nxt] = now[1] + 1;
                q.offer(new int[] { nxt, now[1] + 1 });
            }
        }
    }
}
