package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_25378 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[2501];
        int[] dp = new int[2501];
        boolean[][] check = new boolean[2501][2501];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag;
        int std;
        for (int i = 1; i < N; i++) {
            flag = true;
            std = num[i];

            for (int j = i + 1; j <= N; j++) {
                if (std == num[j]) check[i][j] = flag;
                else {
                    check[i][j] = false;
                    if (std > num[j]) flag = false;
                }
                std = Math.abs(std - num[j]);
            }

        }
        
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j < i; j++) {
                if (!check[j][i])
                    continue;

                dp[i] = Math.min(dp[i], dp[j - 1] + (i - j));
            }
        }
        
        System.out.print(dp[N]);
    }
}
