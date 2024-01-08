package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_2625 {

    static int T, K;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        dp = new int[K+1][T+1];

        List<int[]> arr = new ArrayList<>();

        int p, n;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            p = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            arr.add(new int[] { p, n });
        }

        arr.add(new int[] { 0, 0 });
        arr.sort((o1, o2) -> (o1[0] - o2[0]));
        
        for (int i = 0; i <= K; i++) {
            dp[i][0] = 1;
        }

        int[] now;
        for (int i = 1; i <= K; i++) {
            now = arr.get(i);
            p = now[0];
            n = now[1];

            for (int j = 1; j <= T; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j - (p * k) < 0)
                        break;

                    dp[i][j] += dp[i - 1][j - (p * k)];
                }
            }
        }
        System.out.println(dp[K][T]);
    }
}
