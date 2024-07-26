package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_16493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] pages = new int[M][2];
        int[] dp = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            pages[i][0] = Integer.parseInt(st.nextToken());
            pages[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            for (int j = N; j >= pages[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - pages[i][0]] + pages[i][1]);
            }
        }

        System.out.print(dp[N]);
    }
}
