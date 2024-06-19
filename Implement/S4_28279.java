package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S4_28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());

            if (a == 1 || a == 2) {
                b = Integer.parseInt(st.nextToken());

                if (a == 1)
                    dq.addFirst(b);
                else
                    dq.addLast(b);
            }

            if (a == 3) {
                sb.append(dq.size() != 0 ? dq.pollFirst() : -1).append("\n");
            }

            if (a == 4) {
                sb.append(dq.size() != 0 ? dq.pollLast() : -1).append("\n");
            }

            if (a == 5) {
                sb.append(dq.size() + "\n");
            }

            if (a == 6) {
                sb.append(dq.isEmpty() ? 1 : 0).append("\n");
            }

            if (a == 7) {
                sb.append(dq.size() != 0 ? dq.peekFirst() : -1).append("\n");
            }

            if (a == 8) {
                sb.append(dq.size() != 0 ? dq.peekLast() : -1).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
