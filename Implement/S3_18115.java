package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S3_18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        
        st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
        int v, tmp;
        for (int i = 1; i <= N; i++) {
            v = Integer.parseInt(st.nextToken());

            if (v == 1) {
                q.addFirst(i);
            } else if (v == 2) {
                tmp = q.removeFirst();
                q.addFirst(i);
                q.addFirst(tmp);
            } else {
                q.addLast(i);
            }
        }

        while(!q.isEmpty()) {
            sb.append(q.removeFirst() + " ");
        }

        System.out.print(sb);
    }
}
