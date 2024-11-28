package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class S2_15812 {

    static int N, M, cnt, res;
    static int[][] board;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        cnt = 0;
        String[] s;
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(s[j]);
                if (board[i][j] == 1) cnt++;
            }
        }

        res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    for (int a = i; a < N; a++) {
                        for (int b = j; b < M; b++) {
                            if (a == i && b == j)
                                continue;

                            check(i, j, a, b);
                        }
                    }
                }
            }
        }
        System.out.print(res);
    }
    
    static void check(int x1, int y1, int x2, int y2) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            tmp[i] = board[i].clone();
        }

        tmp[x1][y1] = 2;
        tmp[x2][y2] = 2;
        q.offer(new int[] { x1, y1 });
        q.offer(new int[] { x2, y2 });

        int t = 0;
        int v = 0;

        int[] now;
        int std, nx, ny;
        while (!q.isEmpty()) {
            t++;
            std = q.size();

            while (std-- > 0) {
                now = q.poll();
                for (int[] move : moves) {
                    nx = now[0] + move[0];
                    ny = now[1] + move[1];

                    if (!isPossible(nx, ny))
                        continue;
                    if (tmp[nx][ny] == 2)
                        continue;

                    if (tmp[nx][ny] == 1)
                        v++;
                    tmp[nx][ny] = 2;
                    q.offer(new int[] { nx, ny });
                }
            }
            if (v == cnt)
                break;
        }
        res = Math.min(res, t);
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
