package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_17845 {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[K+1][2];
        int[][] dp = new int[K + 1][N + 1];

        int v, t;
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            arr[i][0] = t;
            arr[i][1] = v;
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][0] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j - arr[i][0]] + arr[i][1], dp[i - 1][j]);
            }
        }

        System.out.print(dp[K][N]);
    }
}
