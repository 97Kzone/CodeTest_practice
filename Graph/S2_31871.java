package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S2_31871 {

    static long res;
    static int N, M;
    static boolean[] visit;
    static List<int[]>[] graph;
    static Map<Integer, Map<Integer, Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N + 1];
        map = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            map.put(i, new HashMap<>());
        }

        int s, e, v;
        Map<Integer, Integer> tmp;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            if (s == e) continue;
            
            tmp = map.get(s);
            if (tmp.containsKey(e)) {
                tmp.put(e, Math.max(tmp.get(e), v));
            } else {
                tmp.put(e, v);
            }
        }

        for (int i = 0; i <= N; i++) {
            tmp = map.get(i);

            for (int k : tmp.keySet()) {
                v = tmp.get(k);
                graph[i].add(new int[] {k, v});
            }
        }

        res = -1;
        visit = new boolean[N + 1];
        check(0, 0, 0);
        
        System.out.print(res);
    }

    static void check(int idx, int v, int cnt) {
        if (idx == 0 && cnt == N + 1) {
            res = Math.max(res, v);
            return;
        }

        for (int[] nxt : graph[idx]) {
            if (visit[nxt[0]]) continue;

            visit[nxt[0]] = true;
            check(nxt[0], nxt[1] + v, cnt + 1);
            visit[nxt[0]] = false;
        }
    }
}
