package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_2491 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int res1 = 1, res2 = 1;
        int cnt = 1;
        int std = num[0];
        // 1. 증가
        for (int i = 1; i < N; i++) {
            if (num[i] >= std) {
                std = num[i];
                cnt++;
            } else {
                res1 = Math.max(res1, cnt);
                std = num[i];
                cnt = 1;
            }
        }
        res1 = Math.max(res1, cnt);

        cnt = 1;
        std = num[0];
        // 2. 감소
        for (int i = 1; i < N; i++) {
            if (num[i] <= std) {
                std = num[i];
                cnt++;
            } else {
                res2 = Math.max(res2, cnt);
                std = num[i];
                cnt = 1;
            }
        }
        res2 = Math.max(res2, cnt);

        System.out.print(Math.max(res1, res2));
    }

}
