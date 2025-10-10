package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_25511 {

    static int N, K, res;
    static List<Integer>[] graph;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        check();

        System.out.print(res);
    }

    static void check() {
        boolean[] visit = new boolean[N];
        visit[0] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});

        int[] now;
        while(!q.isEmpty()) {
            now = q.poll();

            if (nums[now[0]] == K) {
                res = now[1];
                return;
            }

            for (int nxt : graph[now[0]]) {
                if (visit[nxt]) continue;

                visit[nxt] = true;
                q.offer(new int[] {nxt, now[1] + 1});
            }
        }
    }
}
