package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_10835 {

    static int N;
    static int[] l, r;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        l = new int[N];
        r = new int[N];
        dp = new int[N][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            r[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        int res = check(0, 0);
        System.out.print(res);
    }

    static int check(int a, int b) {
        if (a == N || b == N) return 0;

        if (dp[a][b] != -1) return dp[a][b];

        dp[a][b] = Math.max(check(a + 1, b + 1), check(a + 1, b));

        if (l[a] > r[b]) {
            dp[a][b] = Math.max(dp[a][b], check(a, b + 1) + r[b]);
        }

        return dp[a][b];
    }
}
