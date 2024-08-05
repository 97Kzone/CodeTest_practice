package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class S5_26042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> q = new ArrayDeque();

        int a, b;
        int r1 = 0, r2 = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                b = Integer.parseInt(st.nextToken());

                q.offer(b);
            } else {
                q.pop();
            }

            if (r1 < q.size()) {
                r1 = q.size();
                r2 = q.peekLast();
            } else if (r1 == q.size()) {
                r2 = Math.min(r2, q.peekLast());
            }
        }
        
        System.out.print(r1 + " " + r2);
    }
}
