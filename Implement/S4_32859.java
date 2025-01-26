package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_32859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int S = Integer.parseInt(br.readLine());
        int[] group1 = new int[N]; // 폼 제출자 명단
        int[] group2 = new int[N]; // 입금자 명단
        Arrays.fill(group1, -1);
        Arrays.fill(group2, -1);

        int a, b;
        int[] cnt = new int[N];
        boolean[] check = new boolean[N];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine()); 
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken());

            if (b == 1) {
                group2[a] = i;
            } else {
                group1[a] = i;

                for (int j = 0; j < N; ++j) {
                    if (j == a) continue;
                    if (group1[j] != -1) continue;
                    if (group2[j] == -1) continue;
                    if (check[j]) continue;

                    cnt[j]++;

                    if (cnt[j] == S) {
                        check[j] = true;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (!check[i]) continue;

            sb.append(i+1 + "\n");
            res++;
        }

        if (res == 0) sb.append("-1");
        System.out.print(sb.toString());
    }
}
