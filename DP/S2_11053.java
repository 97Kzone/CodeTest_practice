package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2_11053 {
    static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        
        int idx = 0;
        for (String s : br.readLine().split(" ")) {
            nums[idx++] = Integer.parseInt(s);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }  
            }
        }

        int res = 0;
        for (int v : dp) {
            if (res < v) res = v;
        }

        System.out.println(res);
    }
    public static void main(String[] args) throws IOException {
        sol();
    }
}
