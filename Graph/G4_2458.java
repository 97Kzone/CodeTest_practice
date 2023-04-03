package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_2458 {

    static int N, M, res, std;
    static int[][] dp1, dp2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        std = 987654321;
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp1 = new int[N][N];
        dp2 = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp1[i], std);
            Arrays.fill(dp2[i], std);
        }
        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            dp1[a-1][b-1] = 1;
            dp2[b-1][a-1] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    dp1[j][k] = Math.min(dp1[j][k], dp1[j][i] + dp1[i][k]);
                    dp2[j][k] = Math.min(dp2[j][k], dp2[j][i] + dp2[i][k]);
                }
            }
        }

        int cnt;
        for (int i = 0; i < N; i++) {
            cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                cnt += dp1[i][j] == std ? 0 : 1;
                cnt += dp2[i][j] == std ? 0 : 1;
            }
            if (cnt == N-1) res++;
        }
        System.out.println(res);
    }
}
