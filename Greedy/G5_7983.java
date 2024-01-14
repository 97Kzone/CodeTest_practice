package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_7983 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));
        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            pq.offer(new int[] { a, b });
        }

        int std = pq.peek()[1];
        int[] now;
        while (!pq.isEmpty()) {
            now = pq.poll();

            if (now[1] <= std) {
                std = now[1] - now[0];
            } else {
                std -= now[0];
            }

        }

        System.out.print(std);
    }
}
