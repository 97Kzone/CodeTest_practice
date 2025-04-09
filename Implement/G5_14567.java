package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_14567 {

    static int N, M;
    static int[] cnt, depth;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = new int[N+1];
        depth = new int[N+1];
        
        graph = new List[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            cnt[b]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (depth[i] != 0) continue;
            q.offer(i);
            depth[i] = 1;
        }

        int now;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int nxt : graph[now]) {
                depth[nxt] = Math.max(depth[nxt], depth[now] + 1);
                cnt[nxt]--;
                if (cnt[nxt] != 0) continue;
                q.offer(nxt);
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(depth[i] + " ");
        }
        
        System.out.print(sb.toString());
    }
}
