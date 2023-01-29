import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D4_test {
    static int N, M, res;
    static ArrayList<Node>[] graph;
    static int[] dist;

    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];
            dist = new int[N+1];

            for (int i = 1; i < N+1; i++) {
                graph[i] = new ArrayList<>();
            }

            int s, e, c;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
            
                graph[s].add(new Node(e, c));
            }

            res = Integer.MAX_VALUE;
            for (int i = 1; i < N+1; i++) {
                check(i);
            }
        }
    }

    // 다익스트라
    static void check(int n) {
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1]. o2[1]));
        q.offer(new int[] {n, 0});

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int now = tmp[0];
            int cost = tmp[1];

            if (now == n) {
                if (res > dist[now]) res = dist[now];
            }

            if (cost > dist[now]) continue;

            for (int i = 0; i < graph[n].size(); i++) {
                Node node = graph[n].get(i);
                int nxt = node.idx;
                int nxtCost = node.cost;

                if (dist[nxt] > cost + nxtCost) {
                    dist[nxt] = cost + nxtCost;
                    q.offer(new int[] {nxt, cost + nxtCost});
                }
            }
        }
    }
}
