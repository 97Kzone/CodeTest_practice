package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S4_32627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Item> pq = new PriorityQueue<>();
        String s = br.readLine();

        for (int i = 0; i < N; i++) {
            pq.offer(new Item(s.charAt(i), i));
        }

        for (int i = 0; i < M; i++) {
            pq.poll();
        }
        
        char[] tmp = new char[N];
        Item now;
        while (!pq.isEmpty()) {
            now = pq.poll();
            tmp[now.idx] = now.c;
        }

        for (char c : tmp) {
            if ('a' <= c && c < 'z') sb.append(c);
        }
        System.out.print(sb);
    }
    
    static class Item implements Comparable<Item> {
        char c;
        int idx;

        Item(char c, int idx) {
            this.c = c;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Item o) {
            if (this.c == o.c) {
                return this.idx - o.idx;
            }
            return this.c - o.c;
        }
    }
}
