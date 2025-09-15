package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class S4_32076 {

    static char[][] board;
    static PriorityQueue<String> pq;
    static boolean[][] visit;
    static int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        pq = new PriorityQueue<>();
        board = new char[3][3];
        visit = new boolean[3][3];

        for (int i = 0; i < 3; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                visit[i][j] = true;
                check(i, j, String.valueOf(board[i][j]));
                visit[i][j] = false;
            }
        }

        System.out.print(pq.poll());
    }

    static void check(int x, int y, String s) {
        if (s.length() == 3) {
            pq.offer(s);
            return;
        }

        int nx, ny;
        for (int[] move : moves) {
            nx = x + move[0];
            ny = y + move[1];

            if (!isPossible(nx, ny)) continue;
            if (visit[nx][ny]) continue;

            visit[nx][ny] = true;
            check(nx, ny, s + board[nx][ny]);
            visit[nx][ny] = false;
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < 3) && (0 <= y && y < 3);
    }
}
