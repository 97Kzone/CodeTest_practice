package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1325 {
    static int N, M, cnt;
    static List<List<Integer>> graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            graph.get(b).add(a);
        }

        int v = 0;
        int[] res = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            cnt = 0;
            check(i);

            res[i] = cnt;
            v = Math.max(cnt, v);
        }

        for (int i = 1; i <= N; i++) {
            if (res[i] == v)
                sb.append(i + " ");
        }
        
        System.out.println(sb.toString());

    }
    
    static void check(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visit[idx] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int nxt : graph.get(now)) {
                if (visit[nxt])
                    continue;

                visit[nxt] = true;
                q.add(nxt);
                cnt++;
            }
        }
    }
}
