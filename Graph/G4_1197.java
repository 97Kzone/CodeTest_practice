package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1197 {
    static int V, E, res;
    static ArrayList<Node>[] graph;
    static boolean[] visit;

    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

    }
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visit = new boolean[V+1];
        graph = new ArrayList[V+1];
        for (int i = 1; i < V+1; i++) {
            graph[i] = new ArrayList<>();
        }

        int s, e, c;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, c));
            graph[e].add(new Node(s, c));
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(1, 0));
        res = 0;
        while (!q.isEmpty()) {
            Node n = q.poll();
            int idx = n.idx;
            int cost = n.cost;

            if (visit[idx]) continue;

            visit[idx] = true;
            res += cost;

            for (Node nxt : graph[idx]) {
                if (!visit[nxt.idx]) {
                    q.offer(nxt);
                }
            }
        }

        System.out.println(res);
    }
}
