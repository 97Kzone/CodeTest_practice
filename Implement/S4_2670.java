package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_2670 {

    static int N;
    static double[] dp;
    static double res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        double[] nums = new double[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }
        
        dp = new double[N];
        dp[0] = nums[0];
        res = dp[0];

        for (int i = 1; i < N; i++) {
            if (dp[i - 1] * nums[i] > nums[i]) {
                dp[i] = dp[i - 1] * nums[i];
            } else {
                dp[i] = nums[i];
            }

            if (dp[i] > res) {
                res = dp[i];
            }
        }

        System.out.printf("%.3f", res);
    }
}
