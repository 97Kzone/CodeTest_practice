package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_32477 {

    static int N, M;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
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

        boolean[] visit = new boolean[N+1];
        int res = 0;
        int cnt, now;
        Queue<Integer> q;
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            cnt = 1;
            q = new ArrayDeque<>();
            q.offer(i);

            while(!q.isEmpty()) {
                now = q.poll();
                for (int nxt : graph[now]) {
                    if(visit[nxt]) continue;
                    cnt++;
                    visit[nxt] = true;
                    q.offer(nxt);
                }
            }

            res = Math.max(res, cnt);
        }

        System.out.print(res);
    }
}
