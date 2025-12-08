package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S3_30701 {

    static int N;
    static long D;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Long.parseLong(st.nextToken());

        PriorityQueue<Long> pq1 = new PriorityQueue<>(); // 몹
        PriorityQueue<Long> pq2 = new PriorityQueue<>(); // 무기

        int a;
        long b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Long.parseLong(st.nextToken());

            if (a == 1) pq1.offer(b);
            else pq2.offer(b);
        }

        int cnt = pq2.size(); 

        while (!pq1.isEmpty()) {
            while (!pq2.isEmpty() && pq1.peek() >= D) {
                D *= pq2.poll();
            }
            
            if (pq1.peek() < D) {
                cnt++;
                D += pq1.poll();
            } else {
                break; 
            }
        }

        System.out.print(cnt);
    }
}