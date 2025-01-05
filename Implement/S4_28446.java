package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_28446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int M = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        int c, a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            if (c == 1) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                map.put(b, a);
            } else {
                a = Integer.parseInt(st.nextToken());

                sb.append(map.get(a) + "\n");
            }
        }

        System.out.print(sb);

    }
}
