package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_2638 {
    static int N, M, cnt, res;
    static int[][] board;
    static boolean[][] visit;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 1) cnt++; // 치즈 개수 카운팅
            }
        }

        visit = new boolean[N][M];
        res = 0;
        while (cnt > 0) {
            for (int i = 0; i < N; i++) Arrays.fill(visit[i], false);
            res++;
            check();
        }
        
        System.out.println(res);
    }

    static void check() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        visit[0][0] = true;


        // 치즈의 맞닿은 면 개수 체크
        int[][] num = new int[N][M];

        while(!q.isEmpty()) {
            int[] now = q.poll();

            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = now[0] + moves[i][0];
                ny = now[1] + moves[i][1];

                if (!isPossible(nx, ny) || visit[nx][ny]) continue;

                if (board[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                } else {
                    num[nx][ny]++;
                    if (num[nx][ny] == 2) {
                        cnt--;
                        board[nx][ny] = 0;
                        visit[nx][ny] = true; 
                    }
                }
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
