package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class S5_24509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((o1, o2) -> {
            if (o2[1] == o1[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((o1, o2) -> {
            if (o2[1] == o1[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        PriorityQueue<int[]> pq3 = new PriorityQueue<>((o1, o2) -> {
            if (o2[1] == o1[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        PriorityQueue<int[]> pq4 = new PriorityQueue<>((o1, o2) -> {
            if (o2[1] == o1[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        
        int X, A, B, C, D;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            X = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            pq1.offer(new int[] { X, A });
            pq2.offer(new int[] { X, B });
            pq3.offer(new int[] { X, C });
            pq4.offer(new int[] { X, D });
        }
        
        Set<Integer> set = new HashSet<>();
        int[] now;
        while (true) {
            now = pq1.poll();
            if (!set.contains(now[0])) {
                set.add(now[0]);
                sb.append(now[0] + " ");
                break;
            }
        }
        while (true) {
            now = pq2.poll();
            if (!set.contains(now[0])) {
                set.add(now[0]);
                sb.append(now[0] + " ");
                break;
            }
        }
        while (true) {
            now = pq3.poll();
            if (!set.contains(now[0])) {
                set.add(now[0]);
                sb.append(now[0] + " ");
                break;
            }
        }
        while (true) {
            now = pq4.poll();
            if (!set.contains(now[0])) {
                set.add(now[0]);
                sb.append(now[0] + " ");
                break;
            }
        }
        
        System.out.print(sb);
    }
}
