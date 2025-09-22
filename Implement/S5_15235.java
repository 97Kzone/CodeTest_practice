package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class S5_15235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Queue<int[]> q = new ArrayDeque<>();
        int[] time = new int[N];

        st = new StringTokenizer(br.readLine());
        int v;
        for (int i = 0; i < N; i++) {
            v = Integer.parseInt(st.nextToken());
            q.offer(new int[] {v, i, 0});
        }

        int[] now;
        int cnt = 1;
        while(!q.isEmpty()) {
            now = q.poll();
            if (now[0] == 0) {
                time[now[1]] = now[2];
                continue;
            }

            q.offer(new int[] {now[0] - 1, now[1], cnt++});
        }

        for (int n : time) {
            bw.write(n + " ");
        }

        bw.flush();
        bw.close();
    }
}
