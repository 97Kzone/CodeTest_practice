package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class S5_20861 {

    static int R, C;
    static char[][] board;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        R = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        String res = check();
        System.out.print(res);
    }

    static String check() {
        visit = new boolean[R][C];
        visit[0][0] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});

        int[] now;
        int x, y;
        int nx = 0, ny = 0;
        while(!q.isEmpty()) {
            now = q.poll();

            x = now[0];
            y = now[1];
            
            if (board[x][y] == '<') {
                nx = x;
                ny = y - 1;
            } else if (board[x][y] == '>') {
                nx = x;
                ny = y + 1;
            } else if (board[x][y] == '^') {
                nx = x - 1;     
                ny = y;
            } else if (board[x][y] == 'v') {
                nx = x + 1;
                ny = y;
            } else if (board[x][y] == 'B') {
                return "samuraj";
            } else if (board[x][y] == 'A') {
                return "sushi";
            }

            if (visit[nx][ny]) return "cykel";
            q.offer(new int[] {nx, ny});
            visit[nx][ny] = true;
        }

        return "";
    }
}
