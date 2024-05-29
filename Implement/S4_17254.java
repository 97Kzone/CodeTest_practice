package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S4_17254 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int a, b;
        String c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = st.nextToken();

            pq.offer(new Node(a, b, c));
        }
        
        while (!pq.isEmpty()) {
            sb.append(pq.poll().c);
        }

        System.out.print(sb);
    }
    
    static class Node implements Comparable<Node> {
        int a;
        int b;
        String c;

        Node(int a, int b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Node n) {
            if (this.b == n.b) {
                return this.a - n.a;
            }
            return this.b - n.b;
        }

        @Override
        public String toString() {
            return this.a + " " + this.b + " " + this.c;
        }
    }
}
