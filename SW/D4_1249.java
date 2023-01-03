import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1249 {
    static int N;
    static int res;
    static int[][] board;
    static int[][] dp;
    static boolean[][] visit;
    static int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            visit = new boolean[N][N];

            for (int i=0; i<N; i++) {
                String s = br.readLine();
                for (int j=0; j<N; j++) {
                    board[i][j] = s.charAt(j)-'0';
                }
            }
            visit[0][0] = true;
            res = Integer.MAX_VALUE;
            BFS(0, 0);
            System.out.printf("#%d %d\n", t, res);
        }
    }

    public static void BFS(int a, int b) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{a, b, 0});
        dp = new int[N][N];
    
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int c = now[2];

            if (x == N-1 && y == N-1) {
                res = Math.min(res, c);
                continue;
            }

            for (int i=0; i<4; i++) {
                int nx = x + moves[i][0];
                int ny = y + moves[i][1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    int nc = c + board[nx][ny];
                    
                    if (!visit[nx][ny]) {
                        visit[nx][ny] = true;
                        dp[nx][ny] = nc;
                        q.add(new int[]{nx, ny, nc});
                    } else {
                        if (nc < dp[nx][ny]) {
                            dp[nx][ny] = nc;
                            q.add(new int[] {nx, ny, nc});
                        }
                    }
                }
            }
        }
    }
}
