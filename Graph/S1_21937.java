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

public class S1_21937 {

    static int N, M, X;
    static List<Integer>[] graph;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph[e].add(s);
        }

        X = Integer.parseInt(br.readLine());

        check();

        System.out.print(set.size());

    }
    
    static void check() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(X);

        int now;
        while (!q.isEmpty()) {
            now = q.poll();

            for (int nxt : graph[now]) {
                if (set.contains(nxt))
                    continue;

                set.add(nxt);
                q.offer(nxt);
            }
        }
    }
}
