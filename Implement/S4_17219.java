package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();

        String k, v;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            k = st.nextToken();
            v = st.nextToken();

            map.put(k, v);
        }

        for (int i = 0; i < M; i++) {
            k = br.readLine();
            sb.append(map.get(k) + "\n");
        }

        System.out.print(sb);
    }
}
