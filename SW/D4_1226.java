import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1226 {
    static int[][] board;
    static boolean[][] visit;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[] start;
    static int[] end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t=1; t<11; t++) {
            String tmp = br.readLine();
            board = new int[16][16];

            for (int i=0; i<16; i++) {
                String s = br.readLine();
                for (int j=0; j<16; j++) {
                    board[i][j] = s.charAt(j) - '0';
                    if (board[i][j] == 2) {
                        start = new int [] {i, j};
                    } else if (board[i][j] == 3) {
                        end = new int [] {i, j};
                    }
                }
            }
            visit = new boolean[16][16];
            visit[0][0] = true;
            int res = BFS(start[0], start[1]);

            System.out.printf("#%d %d\n", t, res);
        }
    }

    public static int BFS(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {a, b});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            if (x == end[0] && y == end[1]) {
                return 1;
            }

            for (int i=0; i<4; i++) {
                int nx = x + moves[i][0];
                int ny = y + moves[i][1];

                if (nx > 0 && ny > 0 && nx < 16 && ny < 16) {
                    if (board[nx][ny] != 1 && visit[nx][ny] == false) {
                        visit[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
        return 0;
    }
}
