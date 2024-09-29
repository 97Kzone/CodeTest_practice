package DP;

import java.util.*;
import java.io.*;

public class S1_22869 {

    static int N, K;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (dp[i] == 1 && (j - i) * (1 + Math.abs(nums[j] - nums[i])) <= K) {
                    dp[j] = 1;
                }
            }
        }

        System.out.print(dp[N-1] == 1 ? "YES" : "NO");
    }
}
