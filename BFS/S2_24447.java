package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_24447 {

    static int N, M, R;
    static long[] t, d;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        t = new long[N + 1];
        d = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            d[i] = -1;
        }

        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        check();
        long res = 0;
        for (int i = 1; i <= N; i++) {
            res += d[i] * t[i];
        }
        System.out.print(res);

    }
    
    static void check() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(R);

        d[R] = 0;
        t[R] = 1;
        long tmp = t[R];

        int now;
        while (!q.isEmpty()) {
            now = q.poll();

            for (int nxt : graph[now]) {
                if (d[nxt] != -1) continue;

                d[nxt] = d[now] + 1;
                tmp++;
                t[nxt] = tmp;
                q.offer(nxt);
            }
        }
    }
}
