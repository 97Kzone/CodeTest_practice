package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1647 {
    static int N, M, res, max;
    static boolean[] visit;
    static ArrayList<Node>[] graph;
 
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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        visit = new boolean[N+1];
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
            graph[e].add(new Node(s, c));
        }

        res = 0;
        max = 0;
        check();
        System.out.println(res-max);
    }

    static void check() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(1, 0));
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            int idx = node.idx;
            int cost = node.cost;

            if (visit[idx]) continue;

            visit[idx] = true;
            res += cost;

            max = max < cost ? cost : max;
            for (Node nxt : graph[idx]) {
                if (!visit[nxt.idx]) {
                    q.offer(nxt);
                }
            }
        }
    }
}
