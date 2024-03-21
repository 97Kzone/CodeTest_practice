package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] num1 = new int[N + 1];
        int[] num2 = new int[N + 1];
        int[][] dp = new int[N+1][101];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 100; j++) {
                if (num1[i] <= j) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num1[i]] + num2[i]);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.print(dp[N][99]);
    }
}
