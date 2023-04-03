package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2_1058 {
    static int N, std;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        
        N = Integer.parseInt(br.readLine());
        dp = new int[N][N];
        std = 987654321;

        for (int i = 0; i < N; i++) Arrays.fill(dp[i], std);
        
        String s = "";
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (i == j) dp[i][j] = 0;
                if (s.charAt(j) == 'Y') dp[i][j] = 1;
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }

        int res = 0;
        int cnt;
        for (int i = 0; i < N; i++) {
            cnt = 0;
            for (int n : dp[i]) if (n == 1 || n == 2) cnt ++; 
            
            if (cnt > res) res = cnt;
        }

        System.out.println(res);
    }
}
