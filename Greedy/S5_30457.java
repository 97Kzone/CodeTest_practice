package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class S5_30457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        
        if (N < 2) {
            System.out.print(N);
            return;
        }
        
        stk1.push(pq.poll());
        stk2.push(pq.poll());
        int res = 2;

        int std;
        while (!pq.isEmpty()) {
            std = pq.poll();

            if (stk1.peek() < std) {
                stk1.push(std);
                res++;
                continue;
            }

            if (stk2.peek() < std) {
                stk2.push(std);
                res++;
                continue;
            }
        }
        System.out.print(res);
    }
}
