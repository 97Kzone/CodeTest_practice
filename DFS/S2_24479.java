package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S2_24479 {

    static int N, M, R, cnt;
    static PriorityQueue<Integer>[] graph;
    static StringBuilder sb;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new PriorityQueue[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new PriorityQueue<>();
        }

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph[s].offer(e);
            graph[e].offer(s);
        }

        cnt = 1;
        visit = new int[N+1];
        check(R);
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i] + "\n");
        }

        System.out.print(sb.toString());
    }

    static void check(int now) {
        visit[now] = cnt++;

        int nxt;
        while(!graph[now].isEmpty()) {
            nxt = graph[now].poll();

            if (visit[nxt] != 0) continue;
            check(nxt);
        }
    }
}
