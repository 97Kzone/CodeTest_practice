package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_17406 {
    static int N, M, K, res;
    static int[][] board, cmd;
    static int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        cmd = new int[K][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cmd[i][j] = Integer.parseInt(st.nextToken()) ;
                if (j < 2) cmd[i][j]--;
            }
        }
        
        res = 987654321;
        pm(0, 0);
        System.out.print(res);
    }

    static void pm(int cnt, int flag) {
        if (cnt == K) {
            res = Math.min(res, check());
            return;
        }

        int[][] cboard = new int[N][];
        for (int i = 0; i < N; i++) cboard[i] = board[i].clone();

        for (int i = 0; i < K; i++) {
            if ((flag & 1 << i) != 0) continue;
            rotate(cmd[i]);
            pm(cnt + 1, flag | 1 << i);
            for (int j = 0; j < N; j++) board[j] = cboard[j].clone();
        }
    }
    static void rotate(int[] arr) {
        int x = arr[0];
        int y = arr[1];
        int s = arr[2];

        int nx, ny, tmp;
        for (int i = 1; i <= s; i++) {
            nx = x - i;
            ny = y - i;
            tmp = board[nx][ny];

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2 * i; k++) {
                    nx += moves[j][0];
                    ny += moves[j][1];
    
                    int v = board[nx][ny];
                    board[nx][ny] = tmp;
                    tmp = v;
                }
            }

        }
    }

    static int check() {
        int val = 987654321;
        int cnt;
        for (int i = 0; i < N; i++) {
            cnt = 0;
            for (int j = 0; j < M; j++) {
                cnt += board[i][j];
            }
            val = Math.min(val, cnt);
        }

        return val;
    }
}
