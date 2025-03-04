package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S4_31796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int std = pq.poll();
        int res = 1;

        int now;
        while(!pq.isEmpty()) {
            now = pq.poll();
            if (std * 2 <= now) {
                std = now;
                res++;
            }
        }
        System.out.print(res);
    }
}
