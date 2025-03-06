package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S2_24484 {

    static int N, M, R, cnt;
    static PriorityQueue<Integer>[] pq;
    static int[] visit;
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue[N+1];
        for (int i = 1; i <= N; i++) {
            pq[i] = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        }

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            pq[s].offer(e);
            pq[e].offer(s);
        }

        visit = new int[N+1];
        res = 0;
        check(R, 0);

        System.out.print(res);
    }

    static void check(int now, long d) {
        res += (++cnt * d);
        visit[now] = cnt;

        int std;
        while(!pq[now].isEmpty()) {
            std = pq[now].poll();

            if (visit[std] != 0) continue;
            check(std, d + 1);
        }
    }
}
