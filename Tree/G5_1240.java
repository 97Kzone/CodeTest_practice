package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_1240 {
    static int N, M;
    static ArrayList<int[]>[] graph;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        int s, e, v;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[s].add(new int[] {e, v});
            graph[e].add(new int[] {s, v});
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            check(s, e);
        }
    }

    static void check(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        visit = new boolean[N+1];
        int[] res = new int[N+1];

        visit[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int[] nxt : graph[now]) {
                if (visit[nxt[0]]) continue;

                res[nxt[0]] += res[now] + nxt[1];

                if (nxt[0] == e) {
                    System.out.println(res[e]);
                    return;
                }

                q.add(nxt[0]);
                visit[nxt[0]] = true;
            }
        }
    }
}
