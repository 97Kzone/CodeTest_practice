package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_13910 {

    static int N, M;
    static int[] wock, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dp = new int[N+1];
        wock = new int[10001];
        
        Arrays.fill(dp, 10001);
        wock[0] = 1;
        dp[0] = 0;

        int idx;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            idx = Integer.parseInt(st.nextToken());
            wock[idx]++;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i/2; j++) {
                if (i == j * 2 && wock[j] > 1) dp[i] = 1;
                else if (i != j * 2 && wock[j] > 0 && wock[i - j] > 0) dp[i] = 1;
                else if (dp[j] != 10001 && dp[i - j] != 10001) dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        
        dp[N] = (dp[N] >= 10001 ? -1 : dp[N]);
		System.out.println(dp[N]);
    }
}
