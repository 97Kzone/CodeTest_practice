package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G5_14585 {

    static int N, M, maxX, maxY;
    static int[][] dp, board;
    static int[][] moves = {{-1, 0}, {0, -1}}; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] tmp = new int[N][2];

        int x, y;
        maxX = 0;
        maxY = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            tmp[i][0] = x;
            tmp[i][1] = y;

            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }

        board = new int[maxX + 1][maxY + 1];
        dp = new int[maxX + 1][maxY + 1];

        for (int i = 0; i < N; i++) {
            x = tmp[i][0];
            y = tmp[i][1];
            board[x][y] = M;
        }

        long res = 0;
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {

                for (int[] move : moves) {
                    int nx = i + move[0];
                    int ny = j + move[1];

                    if (!isPossible(nx, ny)) continue;

                    dp[i][j] = Math.max(dp[i][j], dp[nx][ny]);
                }

                if (board[i][j] != 0) {
                    int dis = i + j;
                    int candy = board[i][j] - dis;
                    if (candy > 0) {
                        dp[i][j] += candy;
                    }
                }

                res = Math.max(res, dp[i][j]);
            }
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x <= maxX) && (0 <= y && y <= maxY);
    }
}