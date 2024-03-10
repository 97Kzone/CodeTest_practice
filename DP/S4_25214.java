package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_25214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;

        int tmp = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, dp[i]);
            tmp = Math.max(tmp, dp[i] - min);

            sb.append(tmp + " ");

        }

        System.out.print(sb);


    }
}
