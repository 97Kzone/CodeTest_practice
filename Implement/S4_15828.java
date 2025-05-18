package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class S4_15828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int v;
        Queue<Integer> q = new ArrayDeque<>();
        while(true) {
            v = Integer.parseInt(br.readLine());

            if (v == -1) break;

            if (v == 0) {
                q.poll();
                cnt--;
            } else {
                if (cnt == N) continue;
                q.offer(v);
                cnt++;
            }
        }

        if (q.isEmpty()) {
            System.out.print("empty");
            return;
        }
        
        while(!q.isEmpty()) {
            sb.append(q.poll() + " ");
        }

        System.out.print(sb.toString());
    }
}
