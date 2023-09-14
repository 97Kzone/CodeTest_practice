import java.util.*;

class Solution {

    static class Edge {
        int dest, cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) { 
        
        int[] answer = {0, Integer.MAX_VALUE};
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.sort(summits);
        Set<Integer> S = new HashSet<>();
        for (int summit : summits) {
            S.add(summit);
        }

        for (int[] path : paths) {
            int s = path[0];
            int e = path[1];
            int c = path[2];
            graph[s].add(new Edge(e, c));
            graph[e].add(new Edge(s, c));
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int gate : gates) {
            q.add(new int[]{0, gate});
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int d = current[0];
            int now = current[1];

            if (S.contains(now) || d > dist[now]) {
                continue;
            }

            for (Edge edge : graph[now]) {
                int t = Math.max(d, edge.cost);
                if (t < dist[edge.dest]) {
                    dist[edge.dest] = t;
                    q.add(new int[]{t, edge.dest});
                }
            }
        }

        for (int idx : summits) {
            if (dist[idx] < answer[1]) {
                answer[0] = idx;
                answer[1] = dist[idx];
            }
        }

        return answer;
    }
}