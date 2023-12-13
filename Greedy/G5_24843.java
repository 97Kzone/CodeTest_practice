package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_24843 {

    static int N, M;
    static PriorityQueue<Integer> pq1, pq2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pq1 = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        pq2 = new PriorityQueue<>((o1, o2) -> (o1 - o2));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq1.add(Integer.parseInt(st.nextToken()));
        }

        check();
        
        int res = 0;
        int t;
        Queue<Integer> q = new ArrayDeque<>();
        while (!pq2.isEmpty()) {
            t = pq2.peek();

            for (int i = 0; i < M; i++) {
                if (pq2.peek() - t == 0)
                    pq2.poll();
                else
                    q.add(pq2.poll() - t);
                if (pq2.isEmpty())
                    break;
            }

            while (!q.isEmpty())
                pq2.offer(q.poll());
            res += t;
            check();
        }
        System.out.print(res);
    }
    
    static void check() {
        while (pq2.size() != M) {
            if (pq1.isEmpty()) break;
            pq2.add(pq1.poll());
        }
    }
}
