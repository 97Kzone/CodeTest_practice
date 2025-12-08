package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S3_30701 {

    static int N, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(); // 몹
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(); // 무기

        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a == 1) pq1.offer(b);
            else pq2.offer(b);
        }

        int now;
        int cnt = 0;
        boolean flag;
        while(true) {
            now = pq1.poll();

            if (D > now) {
                D += now;
                cnt++;
            } else {
                flag = false;
                while(!pq2.isEmpty()) {
                    D *= pq2.poll();
                    cnt++;
                    
                    if (D > now) {
                        flag = true;
                        D += now;
                        cnt++;
                        break;
                    }
                }

                if(!flag) break;
            }
        }

        System.out.print(cnt);
    }
}
