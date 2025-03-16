package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S2_27112 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));

        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            pq.offer(new int[] {a, b});
        }

        int res = 0;
        int v1 = 0, v2 = 0;
        
        int[] now;
        int num;
        while(!pq.isEmpty()) {
            now = pq.poll();
            num = now[0];

            v1 += num - v2 - check(v2 + 1, num);
            v2 = num;
            v1 -= now[1];

            if (v1 < 0) {
                res += Math.abs(v1);
                v1 = 0;
            }

            if (res > v2) {
                res = -1;
                break;
            }
        }

        System.out.print(res);
    }

    static int check(int s, int e) {
        int res = 0;

        for (int i = s; i <= e; i++) {
            if (i % 7 == 0 || i % 7 == 6) {
                res++;
            }
        }
        
        return res;
    }
}
