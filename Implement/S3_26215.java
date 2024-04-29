package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S3_26215 {
    
    static int N;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        int n;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(st.nextToken());
            if (n > 1440) {
                System.out.print(-1);
                return;
            }
            pq.offer(n);
        }

        int res = 0;
        int a, b;
        while (pq.size() > 1) {
            a = pq.poll();
            if (pq.size() > 0) b = pq.poll();
            else b = 0;

            pq.offer(a - b);
            res += b;
        }
        
        res += pq.size() > 0 ? pq.poll() : 0;
        System.out.print(res);
    } 
}
