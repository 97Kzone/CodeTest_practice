package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1504 {
    static int N, M;
    static int INF = 200000000;
    static int[] std;
    static ArrayList<Node>[] graph;

    static class Node {
        int idx, val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        std = new int[N+1];
        graph = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, c));
            graph[e].add(new Node(s, c));
        }

        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int v1 = 0;
        v1 += check(1, n1);
        v1 += check(n1, n2);
        v1 += check(n2, N);

        int v2 = 0;
        v2 += check(1, n2);
        v2 += check(n2, n1);
        v2 += check(n1, N);

        int res;
        if (v1 >= INF && v2 >= INF) res = -1;
        else res = Math.min(v1, v2);

        System.out.println(res);
    }

    static int check(int s, int e) {
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        Arrays.fill(std, INF);
        std[s] = 0;

        q.add(new Node(s, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (std[now.idx] < now.val) continue;

            for (Node nxt : graph[now.idx]) {
                if (std[nxt.idx] > now.val + nxt.val) {
                    std[nxt.idx] = now.val + nxt.val;
                    q.add(new Node(nxt.idx, std[nxt.idx]));
                }
            }
        }
        return std[e]; 
    }
}
