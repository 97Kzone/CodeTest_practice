package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_29634 {

    static int N, M, res;
    static char[][] board;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        res = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '.') {
                    res = Math.max(res, check(i, j));
                } 
            }
        }
        
        System.out.print(res);
    }

    static int check(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        board[x][y] = '*';

        int[] now;
        int nx, ny, cnt;
        cnt = 1;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int[] move : moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];

                if(!isPossible(nx, ny)) continue;
                if(board[nx][ny] == '*') continue;

                q.offer(new int[] {nx, ny});
                cnt++;
                board[nx][ny] = '*';
            }
        }

        return cnt;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
