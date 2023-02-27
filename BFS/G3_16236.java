package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G3_16236 {
    static int N, size, exp, res;
    static int[][] board;
    static boolean[][] visit;
    static int[][] moves = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    static int[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        res = 0;
        size = 2;
        exp = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    s = new int[] {i, j};
                    board[i][j] = 0;
                }
            }
        }

        while (true) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[2] == o2[2]) {
                        if(o1[0] == o2[0]) return o1[1] - o2[1];
                        else return o1[0] - o2[0];
                    } else return o1[2] - o2[2];
                }
            });

            visit = new boolean[N][N];
            pq.offer(new int[] {s[0], s[1], 0});
            visit[s[0]][s[1]] = true;

            boolean flag = false;

            int x, y;
            int[] now;
            while (!pq.isEmpty()) {
                now = pq.poll();
                x = now[0];
                y = now[1];
                System.out.println(x + " " + y + " " + now[2]);

                if (board[x][y] != 0 && board[x][y] < size) {
                    board[x][y] = 0;
                    exp++;
                    res += now[2];
                    flag = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + moves[i][0];
                    int ny = y + moves[i][1];

                    if (!isPossible(nx, ny)) continue;
                    if (visit[nx][ny] || board[nx][ny] > size) continue;

                    visit[nx][ny] = true;
                    pq.add(new int[] {nx, ny, now[2] + 1});
                }
            }

            if (!flag) break;
            if (size == exp) {
                size++;
                exp = 0;
            }
        }

        System.out.print(res);
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}
