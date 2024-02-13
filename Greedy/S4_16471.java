package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S4_16471 {

    static int N;
    static PriorityQueue<Integer> pq1, pq2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        pq1 = new PriorityQueue<>();
        pq2 = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) pq1.offer(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) pq2.offer(Integer.parseInt(st.nextToken()));
            
        int cnt = 0, tmp = 0;
        int std = pq1.poll();
        boolean flag = false;
        while (!pq2.isEmpty()) {
            if (cnt >= (N / 2 + 1)) {
                flag = true;
                break;
            }

            tmp = pq2.poll();
            if (std < tmp) {
                std = pq1.poll();
                cnt++;
            }
        }
        if (flag || cnt >= (N / 2) + 1) System.out.print("YES");
        else System.out.print("NO");
    }
}
