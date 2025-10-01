package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class S1_28471 {

    static int N;
    static char[][] board;
    static int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 'F') {
                    x = i;
                    y = j;
                }
            }
        }

        int res = check(x, y);
        System.out.print(res);
    }

    static int check(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];

        q.offer(new int[] {x, y});
        visit[x][y] = true;

        int cnt = 0;
        int[] now;
        int nx, ny;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int[] move : moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];
                
                if (!isPossible(nx, ny)) continue;
                if (board[nx][ny] == '#') continue;
                if (visit[nx][ny]) continue;

                cnt++;
                q.offer(new int[] {nx, ny});
                visit[nx][ny] = true;
            }
        }

        return cnt;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}
