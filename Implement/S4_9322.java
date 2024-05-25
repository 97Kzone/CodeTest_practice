package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_9322 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<Integer, String> map3 = new HashMap<>();

        int N;
        for (int t = 0; t < T; t++) {
            map1.clear();
            map2.clear();
            map3.clear();

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                map1.put(i, st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                map2.put(st.nextToken(), i);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                map3.put(i, st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                sb.append(map3.get(map2.get(map1.get(i))) + " ");
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
