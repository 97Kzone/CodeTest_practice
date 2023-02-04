package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_1520 {
    static int N, M;
    static int[][] board, dp;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            
            }
        }
        int res = dfs(0, 0);
        System.out.println(res);
    }

    // 어차피 더 높은곳으로 못감
    static int dfs(int x, int y) {
        if (x == N-1 && y == M-1) return 1;
        
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        int dx, dy;
        for (int i = 0; i < 4; i++) {
            dx = x + moves[i][0];
            dy = y + moves[i][1];

            if (dx >= 0 && dy >=0 && dx < N && dy < M) {
                if (board[x][y] > board[dx][dy]) {
                    dp[x][y] += dfs(dx, dy);
                }
            } 
        }

        return dp[x][y];     
    }
    public static void main(String[] args) throws IOException {
        sol();
    }
}
