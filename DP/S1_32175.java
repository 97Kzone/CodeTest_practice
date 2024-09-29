package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_32175 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int std = 1_000_000_007;
        
        long[] dp = new long[H+1];
        dp[0] = 1;

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= H; i++) {
            for (int n : nums) {
                if (i - n < 0)
                    continue;

                dp[i] += dp[i - n];
            }
            dp[i] %= std;
        }

        System.out.print(dp[H]);
    }
}
