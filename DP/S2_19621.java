package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S2_19621 {

    static int N;
    static List<int[]> list;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[Math.max(2, N)];
        list = new ArrayList<>();

        int s, e, v;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            list.add(new int[] { s, e, v });
        }

        dp[0] = list.get(0)[2];
        
        if (N > 1) {
            dp[1] = Math.max(dp[0], list.get(1)[2]);
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + list.get(i)[2]);
            }
        }

        System.out.print(dp[N - 1]);
    }
}
