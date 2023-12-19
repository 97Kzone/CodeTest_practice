package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S1_18230 {

    static int N, A, B;
    static PriorityQueue<Integer> q1, q2; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());


        q1 = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        q2 = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            q1.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            q2.offer(Integer.parseInt(st.nextToken()));
        }


        int res = 0;
        if (N % 2 == 1) {
            res += q1.poll();
            N -= 1;
        }
        
        int t1, t2;
        int a, b;
        for (int i = 0; i < N; i += 2) {
            t1 = 0;
            t2 = 0;

            a = 0;
            b = 0;
            if (q1.size() > 1) {
                a = q1.poll();
                b = q1.peek();
                t1 = a + b;
                q1.offer(a);
            }

            if (!q2.isEmpty()) {
                t2 = q2.peek();
            }

            if (t1 > t2) {
                res += t1;
                q1.poll();
                q1.poll();
            } else {
                res += t2;
                q2.poll();
            }
        }

        System.out.print(res);
    }
}
