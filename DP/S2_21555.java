package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_21555 {

    static int N, K;
    static int[][] nums;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[N][2];
        dp = new long[N][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i][1] = Integer.parseInt(st.nextToken());
        }
        
        dp[0][0] = nums[0][0];
        dp[0][1] = nums[0][1];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + nums[i][0], dp[i - 1][1] + nums[i][0] + K);
            dp[i][1] = Math.min(dp[i - 1][1] + nums[i][1], dp[i - 1][0] + nums[i][1] + K);
        }

        System.out.print(Math.min(dp[N-1][0], dp[N-1][1]));
    }
}
