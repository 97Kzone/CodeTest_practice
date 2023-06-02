package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//플러드 필 알고리즘 적용
public class G2_16946 {
    static int N, M, gIdx;
    static int[][] board, group;
    static boolean[][] visit;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static ArrayList<Integer> groupCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] in = br.readLine().split(" ");

        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);

        board = new int[N][M];
        group = new int[N][M];
        visit = new boolean[N][M];
        groupCnt = new ArrayList<>();
        groupCnt.add(0);

        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        gIdx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) ff(i, j, gIdx++);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) check(i, j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int n : board[i]) {
                sb.append(n);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
    static void check(int a, int b) {
        int tmp = 1;
        int nx, ny;

        boolean[] use = new boolean[groupCnt.size()];
        for (int i = 0; i < 4; i++) {
            nx = a + moves[i][0];
            ny = b + moves[i][1];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (use[group[nx][ny]]) continue;
                tmp += groupCnt.get(group[nx][ny]);
                use[group[nx][ny]] = true;
            }
        }

        board[a][b] = tmp % 10;
    }
    static void ff(int a, int b, int n) {
        if (visit[a][b]) {
            gIdx--; 
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});
        visit[a][b] = true;
        group[a][b] = n;

        int x, y;
        int cnt = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            x = now[0];
            y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + moves[i][0];
                int ny = y + moves[i][1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (board[nx][ny] == 0 && !visit[nx][ny]) {
                        cnt++;
                        visit[nx][ny] = true;
                        group[nx][ny] = n;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        groupCnt.add(cnt);
    }
}
