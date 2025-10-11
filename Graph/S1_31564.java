package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S1_31564 {

    static int N, M, K;
    static boolean[][] trap;
    static int[][] movesOdd = {{-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
    static int[][] movesEven = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, -1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        trap = new boolean[N][M];

        int x, y;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            trap[x][y] = true;
        }

        int res = check();
        System.out.print(res);
    }

    static int check() {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        q.offer(new int[] {0, 0, 0});

        boolean[][] visit = new boolean[N][M];
        visit[0][0] = true;

        int[] now;
        int[][] moves;
        int x, y, nx, ny;
        
        while(!q.isEmpty()) {
            now = q.poll();

            x = now[0];
            y = now[1];

            if (x == N - 1 && y == M - 1) {
                return now[2];
            }

            moves = (x % 2 == 0) ? movesEven : movesOdd;
            for (int[] move : moves) {
                nx = x + move[0];
                ny = y + move[1];

                if (!isPossible(nx, ny)) continue;
                if (visit[nx][ny] || trap[nx][ny]) continue;

                q.offer(new int[] {nx, ny, now[2] + 1});
                visit[nx][ny] = true;
            }
        }

        return -1;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
