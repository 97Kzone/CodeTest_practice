package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_22114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        int[][] dp = new int[N][2];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N-1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 0; i < N - 1; i++) {
            if (nums[i] <= K) {
                dp[i + 1][0] = dp[i][0] + 1;
                dp[i + 1][1] = dp[i][1] + 1;
            } else {
                dp[i + 1][0] = 1;
                dp[i + 1][1] = dp[i][0] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.print(res);
    }
}
