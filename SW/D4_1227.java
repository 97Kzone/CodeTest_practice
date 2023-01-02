import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1227 {
    static int[][] board;
    static int[] start;
    static int[] end;
    static boolean[][] visit;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int nx, ny;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t=1; t<11; t++) {
            String tmp = br.readLine();
            board = new int[100][100];

            for (int i=0; i<100; i++) {
                String r = br.readLine();
                for (int j=0; j<100; j++) {
                    board[i][j] = r.charAt(j)-'0';
                    if (board[i][j] == 2) {
                        start = new int []{i, j};
                    } else if (board[i][j] == 3) {
                        end = new int[]{i, j};
                    }
                }
            }
            visit = new boolean[100][100];
            visit[0][0] = true;

            int res = BFS(start[0], start[1]);
            System.out.printf("#%d %d\n", t, res);
        }
    }

    public static int BFS(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            if (x == end[0] && y == end[1]) {
                return 1;
            }
            for (int i=0; i<4; i++) {
                nx = x + moves[i][0];
                ny = y + moves[i][1]; 

                if (nx >= 0 && ny >= 0 && nx < 100 && ny < 100) {
                    if (board[nx][ny] != 1 && visit[nx][ny] == false) {
                        visit[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return 0;
    }
}
