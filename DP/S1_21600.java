package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_21600 {

    static int N;
    static int[] nums, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        dp = new int[N + 1];
        dp[0] = 1;
        
        int res = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());

            if (i == 0) continue;
            if (nums[i] > dp[i - 1]) dp[i] = dp[i - 1] + 1;
            else dp[i] = nums[i];

            res = Math.max(res, dp[i]);
        }

        System.out.print(res);
    }
}
