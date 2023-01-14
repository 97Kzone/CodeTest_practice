import java.util.*;

public class G4_1753 {
    static int V, E, K;
    static int[] dist;
    static ArrayList<int[]>[] graph;
    static PriorityQueue<int[]> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();

        graph = new ArrayList[V+1];
        for (int i=0; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();

            graph[s].add(new int[]{e, v});
        }

        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ds(K);

        for (int i=1; i<=V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }
    }

    static void ds(int idx) {
        q = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        q.add(new int[]{0, idx});
        dist[idx] = 0;

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            if (dist[cur[1]] < cur[0]) continue;

            for (int[] nxt : graph[cur[1]]) {
                int cost = dist[cur[1]] + nxt[1];
                if (cost < dist[nxt[0]]) {
                    dist[nxt[0]] = cost;
                    q.add(new int[]{cost, nxt[0]});
                }
            }
        }
    } 
}
