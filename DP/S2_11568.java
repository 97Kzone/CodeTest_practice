package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_11568 {

    static int N;
    static int[] nums, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] > dp[res]) {
                dp[++res] = nums[i];
            } else {
                idx = check(0, res, nums[i]);
                dp[idx] = nums[i];
            }
        }

        System.out.print(res);
    }

    static int check(int l, int r, int v) {
        int m;

        while (l < r) {
            m = (l + r) / 2;
            if (dp[m] < v) l = m + 1;
            else r = m;
        }
        
        return r;
    }
}
