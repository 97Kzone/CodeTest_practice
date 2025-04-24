package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_2644 {

    static int N, M, a, b, cnt;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        cnt = -1;
        check();

        System.out.print(cnt);
    }

    static void check() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visit = new boolean[N+1];

        visit[a] = true;
        q.offer(new int[] {a, 0});

        int[] now;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int nxt : graph[now[0]]) {
                if (nxt == b) {
                    cnt = now[1] + 1;
                    return;
                }

                if (visit[nxt]) continue;
                visit[nxt] = true;
                q.offer(new int[] {nxt, now[1] + 1});
            }
        }
    }
}
