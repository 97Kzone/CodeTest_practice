package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_30702 {

    static int N, M;
    static char[][] board1, board2;
    static boolean[][] board3;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board1 = new char[N][M];
        board2 = new char[N][M];
        board3 = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            board1[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            board2[i] = br.readLine().toCharArray();
        }

        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!board3[i][j]) {
                    if (!check(i, j)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) break;
        }

        System.out.print(flag ? "YES" : "NO");
    }

    static boolean check(int x, int y) {
        char std = board1[x][y];
        char std2 = board2[x][y];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        board3[x][y] = true;
        
        int[] now;
        int nx, ny;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int[] move : moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];

                if (!isPossible(nx, ny)) continue;
                if (board3[nx][ny]) continue;
                if (board1[nx][ny] != std) continue;
                
                // board1에서 같은 색이면 board2도 같은 색이어야 함
                if (board2[nx][ny] != std2) {
                    return false;
                }
                
                board3[nx][ny] = true;
                q.offer(new int[] {nx, ny});
            }
        }
        return true;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}