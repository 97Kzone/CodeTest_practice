package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S5_32185 {
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int std = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        
        int x, y, z;
        PriorityQueue<Student> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            pq.offer(new Student(i, x + y + z));
        }


        Student now;
        M--;
        sb.append("0 ");
        while(!pq.isEmpty()) {
            if (M == 0) break;
            
            now = pq.poll();
            if (std >= now.value) {
                M--;
                sb.append(now.idx + " ");
            }
        }

        System.out.print(sb.toString());
    }

    static class Student implements Comparable<Student> {
        int idx;
        int value;

        Student(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Student o) {
            return o.value - this.value;
        }
    }
}

