package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S4_7515 {

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        dp = new int[42];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 42; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }


        int N;
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            bw.write("Scenario " + t + ":\n");
            bw.write(dp[N + 1] + "\n\n");
        }   

        bw.flush();
        bw.close();
    }
}
