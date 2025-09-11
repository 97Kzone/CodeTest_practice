package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S5_16061 {

    static int N, M, K;
    static PriorityQueue<Employee> pq;

    static class Employee implements Comparable<Employee> {
        String name;
        int price;

        Employee (String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public int compareTo(Employee other) {
            return other.price - this.price;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();

        String name;
        int price;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            name = st.nextToken();
            price = Integer.parseInt(st.nextToken());

            pq.offer(new Employee(name, price));
        }

        int cnt = 0;
        int std = 0;
        Employee now;
        List<String> names = new ArrayList<>();
        for (int i = 1; i <= K; i++) {
            now = pq.poll();

            std += now.price;
            names.add(now.name);
            if (std >= M) {
                cnt = i;
                break;
            }
        }

        if(cnt == 0) {
            bw.write("impossible");    
        } else {
            bw.write(cnt + "\n");

            for (String n : names) {
                bw.write(n + ", YOU ARE FIRED!\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
