package Implement;

import java.io.*;
import java.util.*;

public class S4_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N, M;

        Set<Integer> set = new HashSet<>();

        for (int t = 0; t < T; t++) {
            set.clear();

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                if (set.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            }
        }
        
        System.out.print(sb);
    }
}
