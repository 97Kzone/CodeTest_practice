package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S5_30088 {

    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int sum, a;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            sum = 0;

            for (int j = 0; j < a; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            pq.offer(sum);
        }
        
        long res = pq.poll();
        long std = res;
        int tmp;
        while (!pq.isEmpty()) {
            tmp = pq.poll();

            res += std + tmp;
            std = std + tmp;
        }

        System.out.print(res);
    }
}
