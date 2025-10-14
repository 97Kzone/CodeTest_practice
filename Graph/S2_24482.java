package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S2_24482 {

    static int N, M, R;
    static int[] depth;
    static boolean[] visit;
    static ArrayList<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        depth = new int[N+1];
        Arrays.fill(depth, -1);

        visit = new boolean[N+1];

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

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        check(R, 0);

        for (int i = 1; i <= N; i++) {
            bw.write(depth[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void check(int idx, int cnt) {
        visit[idx] = true;
        depth[idx] = cnt;

        for (int nxt : graph[idx]) {
            if (visit[nxt]) continue;

            check(nxt, cnt + 1);
        }
    }
}