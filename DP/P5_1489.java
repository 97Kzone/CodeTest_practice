package DP;

import java.util.*;

public class P5_1489 {
    static class Edge {
        int to, cap, cost, rev;

        Edge(int to, int cap, int cost, int rev) {
            this.to = to;
            this.cap = cap;
            this.cost = cost;
            this.rev = rev;
        }
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static final int INF = (int) 1e9;
    static int n;
    static final int MAX_V = 3002;
    static ArrayList<Edge>[] G = new ArrayList[MAX_V];
    static int[] dist = new int[MAX_V];
    static int[] prevv = new int[MAX_V], preve = new int[MAX_V];
    static int[] inq = new int[MAX_V];

    static void addEdge(int from, int to, int cap, int cost) {
        G[from].add(new Edge(to, cap, cost, G[to].size()));
        G[to].add(new Edge(from, 0, -cost, G[from].size() - 1));
    }

    static Pair min_cost_flow(int s, int t) {
        int res = 0;
        int total = 0;
        Queue<Integer> q = new LinkedList<>();
        while (true) {
            Arrays.fill(dist, INF);
            dist[s] = 0;
            q.add(s);
            inq[s] = 1;
            while (!q.isEmpty()) {
                int here = q.poll();
                inq[here] = 0;
                for (int i = 0; i < G[here].size(); i++) {
                    Edge e = G[here].get(i);
                    if (e.cap > 0 && dist[e.to] > dist[here] + e.cost) {
                        dist[e.to] = dist[here] + e.cost;
                        prevv[e.to] = here;
                        preve[e.to] = i;
                        if (inq[e.to] == 0) {
                            q.add(e.to);
                            inq[e.to] = 1;
                        }
                    }
                }
            }
            if (dist[t] >= 1e9) {
                return new Pair(total, res);
            }
            int d = (int) 1e9;
            for (int v = t; v != s; v = prevv[v]) {
                d = Math.min(d, G[prevv[v]].get(preve[v]).cap);
            }
            res += d * dist[t];
            total += d;
            for (int v = t; v != s; v = prevv[v]) {
                Edge e = G[prevv[v]].get(preve[v]);
                e.cap -= d;
                G[v].get(e.rev).cap += d;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int source = 0;
        int sink = 2005;
        int[] a = new int[1001], b = new int[1001];
        n = sc.nextInt();
        for (int i = 0; i < MAX_V; i++) {
            G[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            addEdge(source, i, 1, 0);
            addEdge(i + n, sink, 1, 0);
            for (int j = 1; j <= n; j++) {
                if (a[i] > b[j])  addEdge(i, j + n, 1, -2);
                 // 이길 수 있는 상대라면 2점
                else if (a[i] == b[j]) addEdge(i, j + n, 1, -1);
                 // 비기는 경우면 1점
                else addEdge(i, j + n, 1, 0); // 그외의 경우는 0점
            }
        }
        Pair node = min_cost_flow(source, sink);
        System.out.println(-node.second);
    }
}