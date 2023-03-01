package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class G3_1774 {
    static int N, M;
    static int[] p;
    static ArrayList<int[]> nodes;
    static ArrayList<double[]> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();
        edges = new ArrayList<>();

        int x, y;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            
            nodes.add(new int[] {x, y});
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                double d = Math.sqrt(checkDist(i, j));

                edges.add(new double[] {i+1, j+1, d});
            }
        }
        makeSet();
        Collections.sort(edges, (o1, o2) -> (Double.compare(o1[2], o2[2])));

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        double res = 0;
        int cnt = 0;
        for (double[] e : edges) {
            if (!union((int)e[0], (int)e[1])) continue;
            res += e[2];
            if (++cnt == N) break;
        }

        System.out.printf("%.2f", res);
    }

    static double checkDist(int i, int j) {
        return (Math.pow((nodes.get(i)[0] - nodes.get(j)[0]), 2) +
        Math.pow((nodes.get(i)[1] - nodes.get(j)[1]), 2));
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
        p = new int[N+1];
        for (int i = 1; i < N+1; i++) p[i] = i;
    }
}
