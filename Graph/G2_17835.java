package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G2_17835 {
    static int N, M, K, resIdx, loc[];
    static List<int[]>[] graph;
    static Long res, dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        loc = new int[K];
        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) graph[i] = new ArrayList<>();

        int s, e, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph[e].add(new int[] {s, c});
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) loc[i] = Integer.parseInt(st.nextToken());

        dist = new Long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        res = 0L;
        resIdx = 0;
        check();

        System.out.println(resIdx);
        System.out.println(res);
    }

    static void check() {
        PriorityQueue<Long[]> pq = new PriorityQueue<>((o1, o2) -> (int) (o1[1] - o2[1]));
        
        for (int idx : loc) {
            pq.offer(new Long[] {(long)idx, 0L});
            dist[idx] = 0L;
        }

        while(!pq.isEmpty()) {
            Long[] now = pq.poll();
            
            int nowIdx = now[0].intValue();

            if (dist[nowIdx] < now[1]) continue;
            for (int[] nxt : graph[nowIdx]) {
                Long nxtDist = nxt[1] + now[1];
                if (nxtDist < dist[nxt[0]]) {
                    dist[nxt[0]] = (long) nxtDist;
                    pq.offer(new Long[] {(long) nxt[0], nxtDist});
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (res < dist[i]) {
                res = dist[i];
                resIdx = i;
            }
        }
    }
}