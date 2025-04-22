package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_1966 {

    static int T, N, M;
    static Queue<int[]> q;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        int n, cnt;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            q = new ArrayDeque<>();
            pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                n = Integer.parseInt(st.nextToken());

                q.offer(new int[] {i, n});
                pq.offer(n);
            }

            cnt = 0;
            int[] now;
            while(!q.isEmpty()) {
                now = q.poll();

                if (now[1] == pq.peek()) {
                    cnt++;
                    pq.poll();

                    if (now[0] == M) {
                        sb.append(cnt + "\n");
                        break;
                    }
                } else {
                    q.offer(now);
                }
            }
        }
        System.out.print(sb.toString());
        
    }
}
