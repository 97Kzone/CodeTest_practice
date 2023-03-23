package DP;

import java.util.Scanner;

public class G4_2758 {
    static int N, M;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();

            dp = new long[N + 1][M + 1];

            int s = 1;
            int e = M / (int) Math.pow(2, N - 1);
            for (int i = 1; i <= e; i++)
                dp[1][i] = 1;

            int std;
            for (int i = 2; i < N + 1; i++) {
                s *= 2;
                e = M / (int) Math.pow(2, N - i);

                for (int j = s; j <= e; j++) {
                    std = j / 2;
                    for (int k = s / 2; k <= std; k++)
                        dp[i][j] += dp[i - 1][k];
                }
            }

            long res = 0;
            for (int i = 1; i < M + 1; i++)
                res += dp[N][i];

            sb.append(res + "\n");
        }
        System.out.print(sb.toString());
    }
}
