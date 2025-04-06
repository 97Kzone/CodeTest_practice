package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_14620 {

    static int N, res;
    static int[][] board;
    static boolean[][] used;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        used = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = Integer.MAX_VALUE;
        check(0, 0);

        System.out.print(res);
    }

    static void check(int sum, int d) {
        if (d == 3) {
            res = Math.min(res, sum);
            return;
        }

        int std;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (used[i][j]) continue;
                if (!isPossible(i, j)) continue;

                std = count(i, j);
                check(sum + std, d + 1);
                clear(i, j);
            }
        }
    }

    static int count(int x, int y) {
        int res = board[x][y];
        used[x][y] = true;

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + moves[i][0];
            ny = y + moves[i][1];

            res += board[nx][ny];
            used[nx][ny] = true;
        }

        return res;
    }

    static boolean isPossible(int x, int y) {
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + moves[i][0];
            ny = y + moves[i][1];
            if(used[nx][ny]) return false;            
        }   

        return true;
    }

    static void clear(int x, int y) {
        int nx, ny;
        used[x][y] = false;
        for (int i = 0; i < 4; i++) {
            nx = x + moves[i][0];
            ny = y + moves[i][1];

            used[nx][ny] = false;
        }
    }
}
