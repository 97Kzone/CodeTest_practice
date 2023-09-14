package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_16568 {

    static int N, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i - a - 1 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - a - 1] + 1);
            }

            if (i - b - 1 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - b - 1] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
