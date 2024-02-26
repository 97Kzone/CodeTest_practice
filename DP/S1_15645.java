package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_15645 {

    static int N;
    static int[] nums, dp1, dp2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[3];
        dp1 = new int[3];
        dp2 = new int[3];

        int a, b, c, d;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++)
                nums[j] = Integer.parseInt(st.nextToken());

            if (i == 0) {
                dp1[0] = dp2[0] = nums[0];
                dp1[1] = dp2[1] = nums[1];
                dp1[2] = dp2[2] = nums[2];
                continue;
            }

            a = dp1[0];
            b = dp2[0];
            c = dp1[1];
            d = dp2[1];

            dp1[0] = nums[0] + Math.min(dp1[0], dp1[1]);
            dp1[1] = nums[1] + Math.min(a, Math.min(dp1[1], dp1[2]));
            dp1[2] = nums[2] + Math.min(c, dp1[2]);

            dp2[0] = nums[0] + Math.max(dp2[0], dp2[1]);
            dp2[1] = nums[1] + Math.max(b, Math.max(dp2[1], dp2[2]));
            dp2[2] = nums[2] + Math.max(d, dp2[2]);
        }

        int res1 = 0, res2 = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            res1 = Math.max(res1, dp2[i]);
            res2 = Math.min(res2, dp1[i]);
        }

        System.out.print(res1 + " " + res2);
    }
}
