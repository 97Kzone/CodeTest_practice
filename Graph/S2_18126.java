package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_18126 {

    static int N;
    static List<Node>[] graph;
    static long[] dist;
    static boolean[] visit;

    static class Node {
        int idx;
        long v;

        Node(int idx, long v) {
            this.idx = idx;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());        
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int s, e, v;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, v));
            graph[e].add(new Node(s, v));
        }

        check();

        long res = 0;
        for (long val : dist) {
            res = Math.max(res, val);
        }
        System.out.print(res);
    }

    static void check() {
        dist = new long[N+1];
        visit = new boolean[N+1];
        Arrays.fill(dist, Long.MIN_VALUE);
        dist[1] = 0;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(1, 0));

        Node now;
        while(!q.isEmpty()) {
            now = q.poll(); 

            if (visit[now.idx]) continue;
            visit[now.idx] = true;

            for (Node nxt : graph[now.idx]) {
                if(visit[nxt.idx]) continue;
                if (dist[nxt.idx] < dist[now.idx] + nxt.v) {
                    dist[nxt.idx] = dist[now.idx] + nxt.v;
                    q.offer(new Node(nxt.idx, dist[nxt.idx]));
                }
            }
        }
    }
}
