package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S5_15702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] score = new int[N];
        Map<Integer, Integer> sum = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        int idx, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            idx = Integer.parseInt(st.nextToken());
            v = 0;

            for (int j = 0; j < N; j++) {
                if ("O".equals(st.nextToken())) {
                    v += score[j];
                }
            }

            sum.put(idx, v);
        }

        int res1 = 100001, res2 = 0;
        for (int k : sum.keySet()) {
            if (res2 < sum.get(k)) {
                res1 = k;
                res2 = sum.get(k);
            } else if (res2 == sum.get(k)) {
                if (k < res1) {
                    res1 = k;
                }
            }
        }

        System.out.print(res1 + " " + res2);
    }
}
