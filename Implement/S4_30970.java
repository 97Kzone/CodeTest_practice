package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S4_30970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int Q, P;

        PriorityQueue<int[]> pq1 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] == o2[1]) ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });

        PriorityQueue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] == o2[0]) ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Q = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            pq1.offer(new int[] { Q, P });
            pq2.offer(new int[] { Q, P });
        }

        int[] tmp1 = pq1.poll();
        int[] tmp2 = pq1.poll();
        int[] tmp3 = pq2.poll();
        int[] tmp4 = pq2.poll();

        sb.append(tmp3[0] + " " + tmp3[1] + " " + tmp4[0] + " " + tmp4[1] + "\n");
        sb.append(tmp1[0] + " " + tmp1[1] + " " + tmp2[0] + " " + tmp2[1]);

        System.out.print(sb.toString());
    }
}
