package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S5_9979 {

    static class Member implements Comparable<Member> {
        String name;
        int weight;

        Member(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        @Override
        public int compareTo(Member o) {
            return o.weight - this.weight;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s, name;
        int w;
        PriorityQueue<Member> pq = new PriorityQueue<>();
        String[] tmp;
        while((s = br.readLine()) != null) {
            if ("START".equals(s)) continue;

            if ("END".equals(s)) {
                while(!pq.isEmpty()) {
                    bw.write(pq.poll().name);
                    bw.write("\n");
                }
                bw.write("\n");
                pq.clear();
            } else {
                tmp = s.split(" ");
                name = tmp[0];
                w = Integer.parseInt(tmp[2]) - Integer.parseInt(tmp[1]);

                pq.offer(new Member(name, w));
            }
        }

        bw.flush();
        bw.close();
    }
}
