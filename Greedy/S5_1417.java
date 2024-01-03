package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S5_1417 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        int std = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < N - 1; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int res = 0;
        int v;
        while (!pq.isEmpty()) {
            v = pq.poll();
            if (std > v) {
                break;
            }

            if (std <= v) {
                pq.offer(v - 1);
                std++;
                res++;
            }
        }

        System.out.print(res);
    }
}
