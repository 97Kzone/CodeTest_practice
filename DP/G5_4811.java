package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_4811 {

    static int N;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();
        while(true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) break;
            sb.append(dp[N][N] + "\n");
        }
        
        System.out.print(sb.toString());
    }

    static void init() {
        dp = new long[31][31];

        dp[1][0] = 1;
        for (int i = 0; i <= 30; i++) {
            for (int j = 0; j <= 30; j++) {
                if (i < 30) {
                    dp[i+1][j] += dp[i][j];
                }

                if (j < i) {
                    dp[i][j+1] += dp[i][j];
                }
            }
        }
    }
}
