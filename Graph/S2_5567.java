package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_5567 {

    static int N, M, res;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        res = 0;
        check();

        System.out.print(res);
    }
    
    static void check() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 1, 0 });

        boolean[] visit = new boolean[N + 1];
        visit[1] = true;

        int[] now;
        while (!q.isEmpty()) {
            now = q.poll();

            for (int nxt : graph[now[0]]) {
                if (visit[nxt] || now[1] == 2)
                    continue;

                res++;
                visit[nxt] = true;
                q.offer(new int[] { nxt, now[1] + 1 });
            } 
        }
    }
}
