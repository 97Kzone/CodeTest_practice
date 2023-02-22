package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1_2098 {
    static int N;
    static int std = 987654321;
    static int[][] graph, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }    
        }

        System.out.println(check(0, 1));
    }

    static int check(int idx, int visit) {
        if (visit == (1 << N) - 1) { // 모든 정점 방문
            return graph[idx][0] == 0 ? std : graph[idx][0]; 
        }
        
        // 값이 갱신된 적이 있으면? => 그대로 사용
        if (dp[idx][visit] != -1) return dp[idx][visit];

        dp[idx][visit] = std;

        for (int i = 1; i < N; i++) {
            // visit = bit mask
            if (graph[idx][i] == 0 || (visit & (1 << i)) != 0) continue;
            
            dp[idx][visit] = Math.min(dp[idx][visit], check(i, visit | (1 << i)) + graph[idx][i]);
        }

        return dp[idx][visit];
    }
}
