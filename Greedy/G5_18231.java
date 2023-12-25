package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class G5_18231 {

    static int N, M, K;
    static List<Integer> res;
    static List<Integer>[] graph;
    static Set<Integer> destroy, check;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        destroy = new HashSet<>();
        check = new HashSet<>();
        graph = new ArrayList[N + 1];
        res = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int u, v;        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            v = Integer.parseInt(st.nextToken());
            destroy.add(v);
            check.add(v);
        }

        boolean flag;
        for (int idx : destroy) {
            flag = true;
            for (int nxt : graph[idx]) {
                if (!destroy.contains(nxt)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                for (int nxt : graph[idx]) {
                    check.remove(nxt);
                }
                check.remove(idx);
                res.add(idx);
            }
        }

        if (check.size() != 0) {
            System.out.print(-1);
            return;
        }

        for (int n : res) {
            sb.append(n + " ");
        }

        System.out.println(res.size());
        System.out.print(sb.toString());
    }
}
