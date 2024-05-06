package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_21317 {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N][2];
        int[] dp = new int[N];

        int a, b;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            nums[i] = new int[] { a, b };
        }

        K = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.print(0);
            return;
        } else if (N == 2) {
            System.out.print(nums[0][0]);
            return;
        }

        dp[1] = nums[0][0];
        dp[2] = Math.min(nums[0][0] + nums[1][0], nums[0][1]);

        for (int i = 3; i < N; i++) {
            dp[i] = Math.min(nums[i - 1][0] + dp[i - 1], nums[i - 2][1] + dp[i - 2]);
        }

        int res = dp[N - 1];
        int[] tmp = deepCopy(dp);

        for (int i = 0; i < N - 3; i++) {
            if (dp[i] + K >= dp[i + 3]) continue;

            tmp[i + 3] = dp[i] + K;
            for (int j = i + 4; j < N; j++) {
                tmp[j] = Math.min(dp[j], Math.min(tmp[j - 1] + nums[j - 1][0], tmp[j - 2] + nums[j - 2][1]));
            }

            res = Math.min(res, tmp[N - 1]);
        }

        System.out.print(res);
    }
    
    static int[] deepCopy(int[] arr) {
        int[] res = new int[N];

        for (int i = 0; i < N; i++) {
            res[i] = arr[i];
        }

        return res;
    }
}
