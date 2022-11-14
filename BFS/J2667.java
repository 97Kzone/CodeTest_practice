package BFS;
import java.util.*;

public class J2667 {
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visit;
    static int N, check;
    static char[][] board;
    static int[] res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new char[N][N];
        visit = new boolean[N][N];
        res = new int[N];
        check = 0;
        for (int i=0; i<N; i++) {
            String tmp = sc.next();
            for (int j=0; j<N; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (board[i][j] == '1' && !visit[i][j]) {
                    check++;
                    BFS(i, j);
                }
            }
        }

        Arrays.sort(res);
        System.out.println(check);
        for (int v : res) {
            if (v != 0) System.out.println(v);
        }
        sc.close();
    }    

    public static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        visit[i][j] = true;

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            
            for (int k=0; k<4; k++) {
                int nx = x + moves[k][0];
                int ny = y + moves[k][1];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (board[nx][ny] == '1') {
                        if (!visit[ny][ny]) {
                            q.add(new int[] {nx, ny});
                            visit[nx][ny] = true;
                            res[check]++;
                        }
                    }
                }
            }
        }
    }
}
