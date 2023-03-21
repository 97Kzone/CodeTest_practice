package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1695 {
    static int N;
    static int[] nums;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        dp = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);

        System.out.print(check(0, N - 1));
    }

    static int check(int l, int r) {
        if (l >= r) // 기저조건
            return 0;

        if (dp[l][r] != -1) { // 이미 탐색한 범위
            return dp[l][r];
        }

        if (nums[l] == nums[r]) { // 현재 가리키는 양 끝이 같으면
            dp[l][r] = check(l + 1, r - 1);
        } else {
            dp[l][r] = Math.min(check(l + 1, r) + 1, check(l, r - 1) + 1);
        }

        return dp[l][r];
    }

}
