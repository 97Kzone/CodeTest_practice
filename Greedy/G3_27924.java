package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_27924 {

    static int N, a, b, c;
    static int[] amap, bmap, cmap;
    static boolean[] tree;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        tree = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int s, e;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        for (int i = 0; i <= N; i++) {
            if (graph[i].size() == 1)
                tree[i] = true;
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        amap = new int[N + 1];
        bmap = new int[N + 1];
        cmap = new int[N + 1];

        Arrays.fill(amap, -1);
        Arrays.fill(bmap, -1);
        Arrays.fill(cmap, -1);

        check(a, 1);
        check(b, 2);
        check(c, 3);

        String res = "NO";

        for (int i = 1; i <= N; i++) {
            if (tree[i] && (amap[i] < bmap[i]) && (amap[i] < cmap[i])) {
                res = "YES";
                break;
            }
        }
        System.out.print(res);
    }
    
    static void check(int idx, int flag) {
        int[] board = flag == 1 ? amap : flag == 2 ? bmap : cmap;
        boolean[] visit = new boolean[N + 1];
        visit[idx] = true;
        board[idx] = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { idx, 1 });

        int[] now;
        while (!q.isEmpty()) {
            now = q.poll();
            for (int nxt : graph[now[0]]) {
                if (visit[nxt])
                    continue;

                if (nxt != idx) {
                    visit[nxt] = true;
                    board[nxt] = now[1];
                    q.offer(new int[] { nxt, now[1] + 1 });
                }
            }
        }
    }
}
