package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class G4_6497 {
    static int M, N, res; // 집, 간선 수
    static int[] p;
    static ArrayList<int[]> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if (M == 0 && N == 0) break;

            edges = new ArrayList<>();
            res = 0;
            int s, e, w;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
    
                res += w;
                edges.add(new int[] {s, e, w});
            }

            makeSet();
            Collections.sort(edges, (o1, o2) -> (o1[2] - o2[2]));
    
            int v = 0, cnt = 0;
            for (int[] eg : edges) {
                if (!union(eg[0], eg[1])) continue;
                v += eg[2];
                if (++cnt == M) break;
            }
            System.out.println(res - v);
        }

    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        if (a < b) p[b] = a;
        else p[a] = b;

        return true;
    }
    static int find(int n) {
        if (n == p[n]) return n;
        return p[n] = find(p[n]);
    }
    static void makeSet() {
        p = new int[M];
        for (int i = 0; i < M; i++) p[i] = i;
    }
}
