package DFS;

import java.util.*;
import java.io.*;

public class S2_24481 {

    static int N, M, R;
    static int[] res;
    static PriorityQueue<Integer>[] pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue[N + 1];
        for (int i = 0; i <= N; i++) {
            pq[i] = new PriorityQueue<>();
        }

        res = new int[N + 1];
        Arrays.fill(res, -1);

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            pq[s].offer(e);
            pq[e].offer(s);
        }

        check(R, 0);

        for (int i = 1; i <= N; i++) {
            sb.append(res[i] + "\n");
        }

        System.out.print(sb);
    }
    
    static void check(int now, int depth) {
        res[now] = depth;
        int nxt;
        while (!pq[now].isEmpty()) {
            nxt = pq[now].poll();
            if (res[nxt] != -1)
                continue;
            
            check(nxt, depth + 1);
;        }
    }
}
