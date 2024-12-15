package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S5_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        String name;
        int age;

        PriorityQueue<Member> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.seq - o2.seq;
            }
            return o1.age - o2.age; 
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            age = Integer.parseInt(st.nextToken());
            name = st.nextToken();

            pq.offer(new Member(name, i, age));
        }

        Member now;
        while (!pq.isEmpty()) {
            now = pq.poll();
            sb.append(now.age + " " + now.name + "\n");
        }

        System.out.print(sb);

    }
    
    static class Member {
        String name;
        int seq;
        int age;

        Member(String name, int seq, int age) {
            this.name = name;
            this.seq = seq;
            this.age = age;
        }
    }
}
