package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_27971 {

    static int N, M, A, B;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        if (A > B) {
            int tmp = A;
            A = B;
            B = tmp;
        }

        dp = new int[N + 1];

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            for (int j = s; j <= e; j++) dp[j] = -1;
        }

        for (int i = 1; i <= N; i++) {
            if (dp[i] == -1) continue;
            if (i < A) {
                dp[i] = -1;
                continue;
            }

            if (i < B) {
                dp[i] = dp[i - A] == -1 ? -1 : dp[i - A] + 1;
                continue;
            }

            if (dp[i - A] == -1 && dp[i - B] == -1) {
                dp[i] = -1;
            } else if (dp[i - A] == -1) {
                dp[i] = dp[i - B] + 1;
            } else if (dp[i - B] == -1) {
                dp[i] = dp[i - A] + 1;
            } else {
                dp[i] = Math.min(dp[i - A], dp[i - B]) + 1;
            }
        }
        
        System.out.print(dp[N]);
    }
}
