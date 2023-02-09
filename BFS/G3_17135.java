package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 조합 + BFS
public class G3_17135 {
    static int N, M, D, res;
    static int[] arr, board[];
    static int[][] moves = {{-1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        arr = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        cb(0, 0);
        System.out.println(res);
    }

    // 가능한 모든 궁수 배치
    static void cb(int cnt, int idx) {
        if (cnt == 3) {
            check();
            return;
        }
        
        for (int i = idx; i < M; i++) {
            arr[cnt] = i;
            cb(cnt + 1, i+1);
        }
    }

    // 현재 배치로 탐색, 마리 수 기록
    static void check() {
        int[][] tmp = board.clone(); // 깊은 복사
        boolean[][] kill;

        for (int i = N - 1; i >= 0; i--) {
            kill = new boolean[N][M];

            for (int a : arr) {
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] {i+1, a});
                
                loop:
                while (!q.isEmpty()) {
                    int[] now = q.poll();
                    int x = now[0];
                    int y = now[1];

                    for (int j = 0; j < 3; i++) {
                        int nx = x + moves[j][0];
                        int ny = y + moves[j][1];

                        if (nx >= 0 && ny >= 0 && nx < i && ny < M) {
                            int dist = Math.abs(nx-i-1) + Math.abs(ny - a);
                            if (dist <= D) {
                                if (board[nx][ny] == 1) {
                                    kill[nx][ny] = true;
                                    break loop;
                                } else {
                                    q.add(new int[] {nx, ny});
                                }
                            }
                        }
                    }
                }
            }

            int cnt = 0;
            for (int j = 0; j < N; i++) {
                for (int k = 0; k < M; j++) {
                    if (kill[j][k]) cnt++;
                }
            }
            res = Math.max(res, cnt);
        }
    }
}
