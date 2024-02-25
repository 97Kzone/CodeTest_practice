package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class S3_30892 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        
        long res = T;
        Stack<Integer> stk = new Stack<>();
        while(!pq.isEmpty()) {
            if (K == 0) break;

            if (pq.peek() >= res) {
                if (stk.isEmpty()) break;

                res += stk.pop();
                K--;
            } else {
                stk.add(pq.poll());
            }
        }
        
        while (!stk.isEmpty()) {
            if (K == 0) break;

            res += stk.pop();
            K--;
        }
        
        System.out.print(res);
    }
}
