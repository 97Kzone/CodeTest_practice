package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_16398 {
    static int N;
    static List<List<Edge>> graph;
    static boolean[] visit;

    static class Edge implements Comparable<Edge> {
        int weight;
        int vertex;

        public Edge(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if (i != j) {
                    graph.get(i).add(new Edge(weight, j));
                    graph.get(j).add(new Edge(weight, i));
                }
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.addAll(graph.get(0));
        visit[0] = true;

        long result = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int weight = edge.weight;
            int vertex = edge.vertex;

            if (!visit[vertex]) {
                result += weight;
                visit[vertex] = true;
                for (Edge next : graph.get(vertex)) {
                    if (!visit[next.vertex]) {
                        pq.offer(next);
                    }
                }
            }
        }

        System.out.print(result);
    }
}
