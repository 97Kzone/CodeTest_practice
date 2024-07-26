package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_20126 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            pq.offer(new int[] { a, a + b });
        }
        
        int[] std = pq.poll();
        int[] now;
        int res = -1;
        
        if (std[0] >= M) {
            res = 0;
        } else if (!pq.isEmpty()) {
            while (!pq.isEmpty()) {
                now = pq.poll();

                if (now[0] - std[1] >= M) {
                    res = std[1];
                    break;
                }
                std = now;
            }
        }
        
        if (res == -1 && S - std[1] >= M) {
            res = std[1];
        }

        System.out.print(res);
    }
}
