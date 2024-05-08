package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S5_5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        StringBuffer s;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int idx = 0;
        while (idx < N) {
            while (st.hasMoreTokens()) {
                s = new StringBuffer(st.nextToken()).reverse();
                pq.offer(Long.parseLong(s.toString()));
                idx++;
            }

            if (idx < N) st = new StringTokenizer(br.readLine());
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll() + "\n");
        }

        System.out.print(sb);
    }
}
