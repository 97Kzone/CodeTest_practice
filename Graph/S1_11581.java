package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_11581 {
    static int N, std;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        std = 987654321;

        N = Integer.parseInt(br.readLine());
        dp = new int[N][N];

        // 초기화
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], std);

        // 그래프 경로 입력
        int M, idx;
        for (int i = 0; i < N-1; i++) {
            M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                idx = Integer.parseInt(st.nextToken());

                dp[i][idx-1] = 1;
            }
        }
        
        // 플로이드 와샬
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }

        String res = "NO CYCLE";
        for (int i = 0; i < N; i++) {
            if (dp[0][i] != std) {
                if (dp[i][i] != std) {
                    res = "CYCLE";
                    break;
                }
            }
        }   
        System.out.println(res);
    }
}
