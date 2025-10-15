package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_16174 {

    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = check();
        System.out.print(flag ? "HaruHaru" : "Hing");
    }

    static boolean check() {
        Queue<int[]> q = new ArrayDeque<>();   
        q.offer(new int[] {0, 0});

        boolean[][] visit = new boolean[N][N];
        visit[0][0] = true;

        int std;
        int[] now;
        int x, y;
        while(!q.isEmpty()) {
            now = q.poll();
            x = now[0];
            y = now[1];
            std = board[x][y];

            if (std == -1) return true;
            if (std == 0) continue;

            if (isPossible(x, y + std) && !visit[x][y + std]) {
                q.offer(new int[] {x, y + std});
                visit[x][y + std] = true;
            }

            if (isPossible(x + std, y) && !visit[x + std][y]) {
                q.offer(new int[] {x + std, y});
                visit[x + std][y] = true;
            }
        }

        return false;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}
