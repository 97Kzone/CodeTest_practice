package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_25706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        
        int std;
        for (int i = N - 1; i >= 0; i--) {
            std = i + nums[i] + 1;

            if (std >= N) dp[i] = 1;
            else dp[i] = dp[std] + 1;
        }
        
        for (int i = 0; i < N; i++) sb.append(dp[i] + " ");
        System.out.print(sb);
    }
}
