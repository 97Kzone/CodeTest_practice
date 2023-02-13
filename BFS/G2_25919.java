package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G2_25919 {
    static int N, M, L, E, K;
    static int[][] board;
    static boolean[][] visit;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static player p;

    static class player {
        int l; // 레벨
        int e; // 잔여 경험치

        player (int l, int e) {
            this.l = l;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        p = new player(L, E);

        board = new int[N][M];
        visit = new boolean[N][M];

        int sx = 0, sy = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == -3) {
                    sx = i;
                    sy = j;
                }
            }
        }

        boolean flag = check(sx, sy);
        System.out.print(flag == true ? "O" : "X");
    }

    // 경험치를 다 먹고 레이드에 도전
    static boolean check(int a, int b) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        q.offer(new int[] {a, b, 0});
        visit[a][b] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int v = now[2];

            // 종료조건에 부합한가?
            if (board[x][y] == -2 && p.l >= K) { 
                return true;
            } else {
                // 경험치 정산
                if (p.l > v) {
                    if (p.l - p.e <= v) {
                        p.e = p.e + v - p.l;
                        p.l += 1;
                    } else {
                        p.e += v;
                    }
                } else {
                    return false;
                }
            }

            // 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + moves[i][0];
                int ny = y + moves[i][1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (board[nx][ny] != -1 && !visit[nx][ny]) { // 벽이 아니고 방문 안했으면
                        visit[nx][ny] = true;
                        if (board[nx][ny] == -2) q.offer(new int[] {nx, ny, 10001});
                        else q.offer(new int[] {nx, ny, board[nx][ny]});
                    }
                }
            }
        }
        return false;
    }
}