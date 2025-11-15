package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_31910 {
    static int n;
    static long[][] arr;
    static long[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        arr = new long[n][n];
        dp = new long[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        
        dp[0][0] = arr[0][0];
        
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] * 2 + arr[0][i];
        }
        
        for (int j = 1; j < n; j++) {
            dp[j][0] = dp[j - 1][0] * 2 + arr[j][0];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) * 2 + arr[i][j];
            }
        }
        
        System.out.println(dp[n - 1][n - 1]);
    }
}