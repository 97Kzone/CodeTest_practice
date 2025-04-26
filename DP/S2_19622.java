package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_19622 {

    static int N;
    static int[][] list;
    static long[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new int[N][3];
        dp = new long[N+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
            list[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list, (o1, o2) -> (o1[1] - o2[1]));

        dp[0] = list[0][2];

        int idx;
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i-1], list[i][2]);

            idx = check(i);
            if (idx == -1) continue;

            dp[i] = Math.max(dp[i], dp[idx] + list[i][2]);
        }

        System.out.print(dp[N-1]);
    }

    static int check(int idx) {
        int l = 0;
        int r = idx - 1;
        int res = -1;

        int m;
        while(l <= r) {
            m = (l + r) / 2;
            if (list[m][1] <= list[idx][0]) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }
}
