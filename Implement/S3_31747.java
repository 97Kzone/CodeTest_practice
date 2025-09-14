package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class S3_31747 {
    
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> dq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        // check
        int res = 0;
        int std;
        while(true) {
            res++;
            std = 0;

            while(dq.size() < K) {
                if (q.size() == 0) break;

                std = q.poll();
                if (std == 1) {
                    dq.addFirst(std);
                } else {
                    dq.addLast(std);
                }
            }

            if (dq.peekFirst() == dq.peekLast()) {
                dq.pollFirst();
            } else {
                dq.pollFirst();
                dq.pollLast();
            }

            if (dq.size() == 0 && q.size() == 0) break;
        }

        System.out.print(res);
    
    }
}
