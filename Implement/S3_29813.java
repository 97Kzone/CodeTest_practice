package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_29813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        String s;
        int n;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            n = Integer.parseInt(st.nextToken());

            map.put(s, n);
            q.add(s);
        }

        while(q.size() > 1) {
            s = q.poll();

            n = map.get(s);
            for (int i = 0; i < n - 1; i++) {
                q.add(q.poll());
            }

            q.poll();
        }

        System.out.print(q.poll());
    }
}
