package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_9575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[] A, B, C;
        int N, M, K;
        Map<Integer, Integer> map;

        for (int t = 0; t < T; t++) {
            map = new HashMap<>();
            
            N = Integer.parseInt(br.readLine());
            A = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());
            B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            K = Integer.parseInt(br.readLine());
            C = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                C[i] = Integer.parseInt(st.nextToken());
            }

            int sum;
            for (int a : A) {
                for (int b : B) {
                    for (int c : C) {
                        sum = a+ b + c;
                        if(isPossible(sum)) {
                            map.put(sum, map.getOrDefault(sum, 0) + 1);
                        }
                    }
                }
            }

            sb.append(map.size()).append("\n");
        }
        System.out.print(sb);
    }

    static boolean isPossible(int v) {
        int a, b;
        while (v > 0) {
            a = v % 10;
            if (a != 5 && a != 8) return false;

            v /= 10;
        }

        return true;
    }
}
