package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_30960 {

    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        long[][] dp = new long[2][N + 1];

        Arrays.fill(dp[0], 1000000000001L);
        Arrays.fill(dp[1], 1000000000001L);

        dp[0][0] = 0;

        for (int i = 2; i <= N; i++) {
            dp[0][i] = Math.min(dp[0][i], dp[0][i - 2] + nums[i] - nums[i - 1]);
            dp[1][i] = Math.min(dp[1][i], dp[1][i - 2] + nums[i] - nums[i - 1]);

            if (i >= 3) {
                dp[1][i] = Math.min(dp[1][i], dp[0][i - 3] + nums[i] - nums[i - 2]);
            }
        }

        System.out.print(dp[1][N]);
    }
}
