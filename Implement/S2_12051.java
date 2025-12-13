package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_12051 {

    static int N, M, Q;
    static int[][] board;
    static boolean[][] visit;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            bw.write("Case #" + t + ":\n");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] tmp = br.readLine().split("");
                for (int j = 0; j < M; j++) {
                    board[i][j] = Integer.parseInt(tmp[j]);
                }
            }

            Q = Integer.parseInt(br.readLine());
            String cmd;
            int a, b, c, cnt;
            for (int q = 0; q < Q; q++) {
                st = new StringTokenizer(br.readLine());

                cmd = st.nextToken();
                if ("Q".equals(cmd)) {
                    cnt = 0;
                    visit = new boolean[N][M];
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (board[i][j] == 0) continue;
                            if (visit[i][j]) continue;
                            cnt++;
                            check(i, j);
                        }
                    }

                    bw.write(cnt + "\n");
                } else {
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    c = Integer.parseInt(st.nextToken());

                    board[a][b] = c;
                }
            }
        }
        bw.flush();
        bw.close();
    }

    static void check(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        visit[x][y] = true;

        int[] now;
        int nx, ny;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int[] move: moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];

                if (!isPossible(nx, ny)) continue;
                if (board[nx][ny] == 0 || visit[nx][ny]) continue;
                
                visit[nx][ny] = true;
                q.offer(new int[] {nx, ny});
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
