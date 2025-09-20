package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S2_5350 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int N, W;
        int[] dp;
        int[] w, v;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            w = new int[N];
            v = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                w[i] = Integer.parseInt(st.nextToken());
                v[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[W + 1];
            for (int i = 0; i < N; i++) {
                for (int j = W; j >= w[i]; j--) {
                    if (j - w[i] >= 0) {
                        dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                    }
                }
            }
            bw.write(dp[W] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
