package Implement;

import java.util.*;
import java.io.*;

public class S3_20301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        int cnt = 0; // 이동한 칸
        int std = 0;
        boolean flag = true;

        int n;
        while (!dq.isEmpty()) {
            n = flag ? dq.pollFirst() : dq.pollLast();

            cnt++;
            if (cnt == K) {
                cnt = 0;
                std++;
                sb.append(n + "\n");
            } else {
                if (flag) dq.addLast(n);
                else dq.addFirst(n);
            }

            if (std == M) {
                std = 0;
                flag = !flag;
            }
        }
        
        System.out.print(sb);
    }
}
