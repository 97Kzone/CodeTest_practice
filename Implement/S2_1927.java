package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class S2_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                if (pq.isEmpty()) bw.write("0");
                else bw.write(pq.poll() + "");
                bw.write("\n");
            } else {
                pq.offer(n);
            }
        }

        bw.flush();
        bw.close();
        
    }
}
