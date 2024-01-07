package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class G5_17265 {

    static int N, res1, res2;
    static String[][] board;
    static int[][] moves = { { 1, 0 }, { 0, 1 } };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new String[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split(" ");
        }
        
        res1 = Integer.MIN_VALUE;
        res2 = Integer.MAX_VALUE;

        check();

        System.out.print(res1 + " " + res2);
    }
    
    static void check() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { Integer.parseInt(board[0][0]), 0, 0, 0 }); // 값, x, y, 기호

        int[] now;
        int nx, ny;
        while (!q.isEmpty()) {
            now = q.poll();

            if (now[1] == N - 1 && now[2] == N - 1) {
                res1 = Math.max(res1, now[0]);
                res2 = Math.min(res2, now[0]);
            }

            for (int[] move : moves) {
                nx = now[1] + move[0];
                ny = now[2] + move[1];

                if (!isPossible(nx, ny))
                    continue;
                
                int flag;
                if (now[3] == 0) {
                    if ("+".equals(board[nx][ny])) {
                        flag = 1;
                    } else if ("-".equals(board[nx][ny])) {
                        flag = 2;
                    } else {
                        flag = 3;
                    }

                    q.offer(new int[] { now[0], nx, ny, flag });
                } else {
                    if (now[3] == 1) {
                        flag = now[0] + Integer.parseInt(board[nx][ny]);
                    } else if (now[3] == 2) {
                        flag = now[0] - Integer.parseInt(board[nx][ny]);
                    } else {
                        flag = now[0] * Integer.parseInt(board[nx][ny]);
                    }

                    q.offer(new int[] { flag, nx, ny, 0 });
                }
            }
        }
    }
    
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}
