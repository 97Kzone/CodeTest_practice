package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_2468 {

    static int N, res;
    static int[][] board, board2;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int std = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                std = Math.max(std, board[i][j]);
            }
        }

        res = 1;
        int cnt;
        for (int h = 1; h <= std; h++) {
            init(h);            

            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(board2[i][j] == 0) continue;
                    
                    check(i, j);
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }

        System.out.println(res);
    }

    static void check(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});

        int[] now;
        int nx, ny;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int i = 0; i < 4; i++) {
                nx = now[0] + moves[i][0];
                ny = now[1] + moves[i][1];

                if(!isPosible(nx, ny)) continue;
                if(board2[nx][ny] == 0) continue;

                board2[nx][ny] = 0;
                q.offer(new int[] {nx, ny});
            }
        }
    }

    static void init(int h) {
        board2 = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] <= h) continue;
                board2[i][j] = 1; 
            }
        }
    }

    static boolean isPosible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N); 
    }
}
