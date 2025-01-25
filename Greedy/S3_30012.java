package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_30012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        int dist, v;
        for (int i = 0; i < N; i++) {
            dist = Math.abs(nums[i] - S);
            v = 0;

            if (dist > K * 2) {
                v += (dist - K * 2) * L;
            } else {
                if (dist % 2 == 0) {
                    v += (K - dist / 2) * 2;
                } else {
                    v += (K - dist / 2) * 2 - 1;
                }
            }
            dp[i] = v;
        }
        int res = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (res > dp[i]) {
                res = dp[i];
                idx = i + 1;
            }
        }
        System.out.println(res + " " + idx);
    }
}
