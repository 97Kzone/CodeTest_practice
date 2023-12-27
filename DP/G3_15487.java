package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_15487 {
    
    static int N, std, min, max, res;
    static int[] nums, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[N];

        dp[0] = Integer.MIN_VALUE;
        std = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        res = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());

            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], nums[i] - min);
            }
            min = Math.min(min, nums[i]);
        }

        max = nums[N - 1];
        for (int i = N - 2; i > 1; i--) {
            std = Math.max(std, max - nums[i]);
            res = Math.max(res, std + dp[i - 1]);
            max = Math.max(max, nums[i]);
        }
        
        System.out.print(res);
    }
}
