package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S2_24480 {

    static int N, M, R;
    static int cnt;
    static int[] res;
    static boolean[] visit;
    static PriorityQueue<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new PriorityQueue[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        }

        res = new int[N + 1];
        visit = new boolean[N + 1];

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph[s].offer(e);
            graph[e].offer(s);
        }

        cnt = 1;
        check(R);

        for (int i = 1; i <= N; i++) {
            sb.append(res[i] + "\n");
        }

        System.out.print(sb);
    }
    
    static void check(int now) {
        visit[now] = true;
        res[now] = cnt++;
        int nxt;
        while (!graph[now].isEmpty()) {
            nxt = graph[now].poll();
            if (visit[nxt]) continue;
            check(nxt);
        }
    }
}
