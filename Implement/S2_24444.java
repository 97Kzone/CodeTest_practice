package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_24444 {

    static int N, M, R;
    static PriorityQueue<Integer>[] pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue[N+1];
        for (int i = 1; i <= N; i++) {
            pq[i] = new PriorityQueue<>();
        }

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            pq[s].offer(e);
            pq[e].offer(s);
        }

        int[] visit = new int[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(R);
        int cnt = 1;
        visit[R] = cnt++;

        int now;
        while (!q.isEmpty()) {
            now = q.poll();

            while (!pq[now].isEmpty()) {
                int nxt = pq[now].poll();
                if (visit[nxt] != 0) continue;

                q.offer(nxt);
                visit[nxt] = cnt++;
            }
        }
        
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i]).append("\n");
        }

        System.out.print(sb);
    }
}
