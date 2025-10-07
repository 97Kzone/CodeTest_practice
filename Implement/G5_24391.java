package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_24391 {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            union(s, e);
        }    
        
        st = new StringTokenizer(br.readLine());
        int std = Integer.parseInt(st.nextToken());
        int idx = find(std);

        int res = 0;
        for (int i = 0; i < N - 1; i++) {
            std = Integer.parseInt(st.nextToken());

            if (idx == find(std)) continue;

            idx = find(std);
            res++;
        }

        System.out.print(res);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        if (a <= b) parent[b] = a;
        else parent[a] = b;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
