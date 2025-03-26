package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_20152 {

    static int H, N, res;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int v = Math.abs(H-N) + 1;
        dp = new long[v][v];

        dp[0][0] = 1;
        for (int i = 1; i < v; i++) {
            dp[i][0] = 1;

            for (int j = 1; j < i+1; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        System.out.print(dp[v-1][v-1]);
    }   
}
