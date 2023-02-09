package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_9252 {
    static String s1, s2;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        s1 = br.readLine();
        s2 = br.readLine();

        int n = s1.length();
        int m = s2.length();

        dp = new int[n+1][m+1];

        // LCS 길이 구하기
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // LCS 구하기
        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i-1][j]) i--;
            else if (dp[i][j] == dp[i][j-1]) j--;
            else {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
        }

        System.out.println(dp[n][m]);
        System.out.println(sb.reverse());
    }
}
