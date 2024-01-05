package DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_2228 {

    static int N, M;
    static int[] sum;
    static int[][] dp;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(br.readLine());
        }

        dp = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1000000000);
        }

        int res = check(N, M);
        System.out.print(res);
    }
    
    static int check(int a, int b) {
        if (b == 0) {
            return 0;
        }
        
        if (a < 0) {
            return -1000000000;
        }

        if (visit[a][b]) {
            return dp[a][b];
        }

        visit[a][b] = true;
        dp[a][b] = check(a - 1, b);

        for (int i = a; i > 0; i--) {
            dp[a][b] = Math.max(dp[a][b], check(i - 2, b - 1) + (sum[a] - sum[i - 1]));
        }

        return dp[a][b];
    }
}
