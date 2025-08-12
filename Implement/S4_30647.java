package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class S4_30647 {

    static int N;

    static class User implements Comparable<User> {
        String name;
        int score;
        int flag;

        User(String name, int score, int flag) {
            this.name = name;
            this.score = score;
            this.flag = flag;
        }

        @Override
        public int compareTo(User o) {
            if (this.score != o.score) return o.score - this.score;

            return this.name.compareTo(o.name);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        PriorityQueue<User> pq = new PriorityQueue<>();

        String[] fields, s;
        String line, k, v;

        String name;
        int score, flag;
        for (int i = 0; i < N; i++) {
            line = br.readLine().trim();

            line = line.substring(1, line.length() - 1);
            fields = line.split(",");

            name = "";
            score = 0;
            flag = 0;
            for (String field : fields) {
                s = field.split(":");
                k = s[0].replace("\"", "").replace("{", "").trim();
                v = s[1].replace("\"", "").replace("}", "").trim();

                if ("name".equals(k)) name = v;
                else if ("score".equals(k)) score = Integer.parseInt(v);
                else if ("isHidden".equals(k)) flag = Integer.parseInt(v);
            }

            pq.offer(new User(name, score, flag));
        }
        
        User user;

        int idx = 0;
        int rank = 0;
        int std = Integer.MIN_VALUE;
        while(!pq.isEmpty()) {
            user = pq.poll();
            idx++;

            if (user.score != std) {
                rank = idx;
                std = user.score;
            }

            if (user.flag == 0) {
                bw.write(rank + " " + user.name + " " + user.score + "\n");
            }

        }

        bw.flush();
        bw.close();
    }
}
