package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class G4_4803 {
    static int N, M;
    static int[] p;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break; // 종료조건

            p = new int[N+1];
            for (int i = 1; i < N+1; i++) {
                p[i] = i;
            }

            int x, y;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                union(x, y);
            }
            set = new HashSet<>();
            for (int i = 1; i < N+1; i++) {
                int p = find(i);
                if (p > 0) set.add(p);
            }

            if (set.isEmpty()) {
                sb.append("Case " + t + ": No trees.\n");
            } else if (set.size() == 1) {
                sb.append("Case " + t + ": There is one tree.\n");
            } else {
                sb.append("Case " + t + ": A forest of " + set.size() + " trees.\n");
            }
    
            t++;
        }
        System.out.print(sb.toString());
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            p[b] = a;
            p[a] = 0;
        } else if (a < b) p[b] = a;
        else p[a] = b;
    }

    static int find(int n) {
        if (n == p[n]) return n;
        else return p[n] = find(p[n]);
    }
}
