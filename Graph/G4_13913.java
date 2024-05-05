package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_13913 {

    static int N, K;
    
    static class Node implements Comparable<Node> {
        int idx;
        int cnt;
        String log;

        Node(int idx, int cnt, String log) {
            this.idx = idx;
            this.cnt = cnt;
            this.log = log;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Node res = check();

        System.out.println(res.cnt);
        for (String s : res.log.split(",")) {
            sb.append(s + " ");
        }

        System.out.print(sb);
    }
    
    static Node check() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[100001];

        pq.offer(new Node(N, 0, N + ""));
        Arrays.fill(dist, Integer.MAX_VALUE);

        Node now;
        int nxt;
        while (!pq.isEmpty()) {
            now = pq.poll();

            if (now.idx == K) {
                return now;
            }

            nxt = now.idx * 2;
            if (isPossible(nxt) && dist[nxt] > now.cnt + 1) {
                dist[nxt] = now.cnt + 1;
                pq.offer(new Node(nxt, now.cnt + 1, now.log + "," + nxt));
            }
            
            nxt = now.idx + 1;
            if (isPossible(nxt) && dist[nxt] > now.cnt + 1) {
                dist[nxt] = now.cnt + 1;
                pq.offer(new Node(nxt, now.cnt + 1, now.log + "," + nxt));
            }

            nxt = now.idx - 1;
            if (isPossible(nxt) && dist[nxt] > now.cnt + 1) {
                dist[nxt] = now.cnt + 1;
                pq.offer(new Node(nxt, now.cnt + 1, now.log + "," + nxt));
            }

        }
        
        return null;
    }
    
    static boolean isPossible(int x) {
        return 0 <= x && x < 100001;
    }
}
