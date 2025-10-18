package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_21938 {

    static int N, M, res;
    static int[][] board;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        int tmp;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tmp = 0;
                for (int k = 0; k < 3; k++) {
                    tmp += Integer.parseInt(st.nextToken());
                }

                board[i][j] = tmp / 3;
            }
        }
        int std = Integer.parseInt(br.readLine());
        
        // 뒤집기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] < std) board[i][j] = 0;
                else board[i][j] = 255;
            }
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) continue;
                res++;
                check(i, j);
            }
        }

        System.out.print(res);
    }

    static void check(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});

        int[] now;
        int nx, ny;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int[] move : moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];

                if(!isPossible(nx, ny)) continue;
                if(board[nx][ny] == 0) continue;

                board[nx][ny] = 0;
                q.offer(new int[] {nx, ny});
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
