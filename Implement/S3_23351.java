package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S3_23351 {

    static int N, K, A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> tmp;
        for (int i = 0; i < N; i++) {
            pq.offer(K);
        }
        
        int res = 0;
        while(true) {
            if (pq.peek() == 0) {
                break;
            }

            // 1. 작은화분 물주기
            for (int i = 0; i < A; i++) {
                pq.offer(pq.poll() + B);
            }

            tmp = new PriorityQueue<>();
            // 2. 모든 화분 물빼기
            for (int i = 0; i < N; i++) {
                tmp.offer(pq.poll() - 1);
            }
            res++;
            pq = tmp;
        }

        System.out.print(res);
    }
}
