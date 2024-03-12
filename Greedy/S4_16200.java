package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S4_16200 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int res = 0, std = 0, cnt = 0;
        int tmp;
        while (!pq.isEmpty()) {
            tmp = pq.poll();
            if (cnt == 0) std = tmp;
            cnt++;

            if (cnt == std) {
                cnt = 0;
                res++;
            }
        }

        System.out.print(cnt != 0 ? res + 1 : res);
    }
}
