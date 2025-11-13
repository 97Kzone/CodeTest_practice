package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S5_23246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int res1, res2, res3;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator
                                    .<int[]>comparingInt(o -> o[0])
                                    .thenComparingInt(o -> o[1])
                                    .thenComparingInt(o -> o[2])
        );

        int id, v1, v2;
        int a, b, c;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            id = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            v1 = a * b * c;
            v2 = a + b + c;
            pq.offer(new int[] {v1, v2, id});
        }

        res1 = pq.poll()[2];
        res2 = pq.poll()[2];
        res3 = pq.poll()[2];

        System.out.println(res1 + " " + res2 + " " + res3);
    }
}

