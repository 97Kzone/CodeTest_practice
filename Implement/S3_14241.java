package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_14241 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<Integer> q = new ArrayDeque<>();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        int res = 0;
        for (int i = 0; i < N; i++)
            q.offer(Integer.parseInt(st.nextToken()));
        
        int a, b;
        while (q.size() != 1) {
            a = q.poll();
            b = q.poll();

            res += a * b;
            q.offer(a + b);
        }

        System.out.println(res);
    }
}
