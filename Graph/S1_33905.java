package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class S1_33905 {

    static int N, M, K, res;
    static List<Integer>[] graph;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+2];
        set = new HashSet<>();
        for (int i = 1; i <= N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        res = 0;
        check();

        System.out.print(res);
    }

    static void check() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        boolean[] visit = new boolean[N+2];
        visit[1] = true;

        int now;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int nxt : graph[now]) {
                if (set.contains(nxt)) continue;
                if (visit[nxt]) continue;

                res++;
                q.offer(nxt);
                visit[nxt] = true;
            }
        }
    }
}
