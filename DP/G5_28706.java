package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_28706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int v1, v2, N;
        boolean[][] dp;
        String op1, op2;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            dp = new boolean[N][7];

            st = new StringTokenizer(br.readLine());
            op1 = st.nextToken();
            v1 = Integer.parseInt(st.nextToken());
            op2 = st.nextToken();
            v2 = Integer.parseInt(st.nextToken());

            int t1 = check(1, op1, v1);
            int t2 = check(1, op2, v2);

            dp[0][t1 % 7] = true;
            dp[0][t2 % 7] = true;

            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                op1 = st.nextToken();
                v1 = Integer.parseInt(st.nextToken());
                op2 = st.nextToken();
                v2 = Integer.parseInt(st.nextToken());

                for (int j = 0; j < 7; j++) {
                    if (!dp[i - 1][j])
                        continue;
                    t1 = check(j, op1, v1);
                    t2 = check(j, op2, v2);

                    dp[i][t1 % 7] = true;
                    dp[i][t2 % 7] = true;
                }

            }
            sb.append(dp[N - 1][0] ? "LUCKY" : "UNLUCKY");
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    static int check(int a, String b, int c) {
        if ("+".equals(b)) return a + c;
        else return a * c;
    }
}
