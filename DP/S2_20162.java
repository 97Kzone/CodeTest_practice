package DP;

import java.io.*;
import java.util.*;

public class S2_20162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            dp[i] = nums[i];
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j])
                    continue;
                
                if (dp[j] + nums[i] <= dp[i])
                    continue;

                dp[i] = dp[j] + nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        System.out.print(res);
    }
}
