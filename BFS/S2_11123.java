package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_11123 {

    static int H, W;
    static char[][] board;
    static int[][] board2;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T =  Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new char[H][W];
            board2 = new int[H][W];
            for (int i = 0; i < H; i++) {
                board[i] = br.readLine().toCharArray();
            }

            int cnt = 1;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (board[i][j] == '.') continue;
                    if (board2[i][j] != 0) continue;
                    
                    check(i, j, cnt);
                    cnt++;
                }
            }

            sb.append(cnt - 1 + "\n");
        }
        System.out.print(sb.toString());
    }

    static void check(int x, int y, int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[] {x, y});
        board2[x][y] = idx;

        int[] now;
        int nx, ny;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int i = 0; i < 4; i++) {
                nx = now[0] + moves[i][0];
                ny = now[1] + moves[i][1];

                if(!isPossible(nx, ny)) continue;
                if(board[nx][ny] == '.') continue;
                if(board2[nx][ny] != 0) continue;

                board2[nx][ny] = idx;
                q.offer(new int[] {nx, ny});
            }
        }
    }
    
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < H) && (0 <= y && y < W);
    }
}
