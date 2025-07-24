package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S2_14012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int std;
        for (int i = 0; i < N; i++) {
            std = Integer.parseInt(st.nextToken());
            if (num[i] >= std) continue;

            pq.offer(new int[] {num[i], std});
        }

        int[] now;
        while(!pq.isEmpty()) {
            now = pq.poll();

            if (M < now[0]) break;
            M -= now[0];
            M += now[1];
        }

        bw.write(M + "");
        bw.flush();
        bw.close();
    }
}
