package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2600 {

    static int b1, b2, b3;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        b1 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());
        b3 = Integer.parseInt(st.nextToken());
        dp = new int[501][501];

        int k1, k2, v;
        for (int t = 0; t < 5; t++) {
            st = new StringTokenizer(br.readLine());

            k1 = Integer.parseInt(st.nextToken());
            k2 = Integer.parseInt(st.nextToken());
            v = check(k1, k2);

            sb.append(v == 2 ? 'A' : 'B').append("\n");
        }
        
        System.out.print(sb);
    }
    
    static int check(int a, int b) {
        if (dp[a][b] != 0) return dp[a][b];
       
        if (b1 <= a && check(a - b1, b) == 1) return dp[a][b] = 2;
        if (b2 <= a && check(a - b2, b) == 1) return dp[a][b] = 2;
        if (b3 <= a && check(a - b3, b) == 1) return dp[a][b] = 2;

        if (b1 <= b && check(a, b - b1) == 1) return dp[a][b] = 2;
        if (b2 <= b && check(a, b - b2) == 1) return dp[a][b] = 2;
        if (b3 <= b && check(a, b - b3) == 1) return dp[a][b] = 2;
        
        dp[a][b] = 1;
        return dp[a][b];
    }
}
