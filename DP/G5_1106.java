package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_1106 {

    static int C, N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new int[C + 100];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;

        int v, cnt;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());

            for (int j = cnt; j < C + 100; j++) {
                if (dp[j - cnt] != 1000000) {
                    dp[j] = Math.min(dp[j], v + dp[j - cnt]);
                }
            }
        }

        int res = 1000000;
        for (int i = C; i < C + 100; i++) {
            res = Math.min(res, dp[i]);
        }

        System.out.print(res);
    }
}
