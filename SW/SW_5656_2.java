import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1. 구슬을 떨어트릴 열 선택
 * 2. 해당 열의 맨 위의 값 찾기
 * 3. 값 만큼 사방 탐색
 * 4. 0 인 값들 내려주기
 */
public class SW_5656_2 {
    static int N, W, H, res;
    static int[] select;
    static int[][] board;
    static boolean[][] visit;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> q = new ArrayDeque<>();;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T ; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            board = new int[H][W];
            select = new int[N];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = 987654321;
            pm(0);
            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    static void pm(int cnt) {
        if (cnt == N) {
            check();
            return;
        }

        for (int i = 0; i < W; i++) {
            select[cnt] = i;
            pm(cnt + 1);
        }
    }

    static void check() {
        int[][] cboard = copyBoard();
        // 1. 구슬을 순서대로 떨어트린다.
        for (int w : select) {
            visit = new boolean[H][W];
            // 2. 최초로 마주하는 값 찾기
            for (int r = 0; r < H; r++) {
                if (cboard[r][w] == 0) continue;
                q.offer(new int[] {r, w, cboard[r][w]});
                visit[r][w] = true;
                break;
            }

            // 3. 트리거 찾기
            int x, y;
            while(!q.isEmpty()) {
                int[] now = q.poll();
                x = now[0];
                y = now[1];
                cboard[x][y] = 0;

                if (now[2] == 1) continue;

                int nx, ny;
                for (int i = 0; i < 4; i++) {
                    nx = x;
                    ny = y;

                    for (int j = 0; j < now[2] - 1; j++) {
                        nx += moves[i][0];
                        ny += moves[i][1];

                        if (!isPossible(nx, ny) || visit[nx][ny]) continue;
                        if (cboard[nx][ny] == 1) cboard[nx][ny] = 0;
                        else q.offer(new int[] {nx, ny, cboard[nx][ny]});

                        visit[nx][ny] = true;
                    }
                }
            }
            setBoard(cboard);
        }
        res = Math.min(res, count(cboard));
    }

    static int count(int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(arr[i][j] != 0) cnt++;
            }
        }
        return cnt;
    }

    static void setBoard(int[][] arr) {
        for (int i = 0; i < W; i++) {
            for (int j = H-1; j >= 0; j--) {
                if (arr[j][i] != 0) continue;

                for (int k = j-1; k >= 0; k--) {
                    if (arr[k][i] == 0) continue;
                    arr[j][i] = arr[k][i];
                    arr[k][i] = 0;
                    break;
                }
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < H) && (0 <= y && y < W);
    }

    static int[][] copyBoard() {
        int[][] r = new int[H][W];
        for (int i = 0; i < H; i++) r[i] = board[i].clone();
        return r;
    }
}
