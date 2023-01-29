import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D4_5684 {
    static int N, M, res;
    static ArrayList<Node>[] graph;
    static int[] std;

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
        for (int  t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            std = new int[N+1];
            graph = new ArrayList[N+1];
            for (int i = 1; i < N+1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph[s].add(new Node(e, c));
            }
            res = Integer.MAX_VALUE;
            for (int i = 1; i < N+1; i++) {
                check(i);
            }

            System.out.printf("#%d %d\n", t, res);
        }
    }

    static void check(int idx) {
        Arrays.fill(std, Integer.MAX_VALUE); // 거리 배열 초기화
        
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        q.offer(new int[] {idx, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int now = tmp[0];
            int val = tmp[1];

            if (now == idx) {
                if (res > std[idx]) res = std[idx];  
            }

            if (val > std[now]) continue;

            for (int i = 0; i < graph[now].size(); i++) {
                Node node = graph[now].get(i);
                int nxt = node.idx;
                int nxtVal = node.cost;

                if (std[nxt] > val + nxtVal) {
                    std[nxt] = val + nxtVal;
                    q.offer(new int[] {nxt, val + nxtVal});
                }
            }
        }
    }
}
