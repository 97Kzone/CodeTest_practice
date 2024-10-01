package DP;

import java.io.*;
import java.util.*;

public class S1_31861 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int std = 1_000_000_007;
        
        long[][] dp = new long[M][26];
        for (int i = 0; i < 26; i++) {
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if (Math.abs(j - k) < N)
                        continue;

                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= std;
                }
            }
        }

        long res = 0;
        for (int i = 0; i < 26; i++) {
            res += dp[M - 1][i];
            res %= std;
        }
        System.out.print(res);
    }
}
