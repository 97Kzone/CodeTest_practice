import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5656 {
    static int N, W, H, res;
    static int[] select;
    static int[][] board;
    static boolean[][] visit;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            board = new int[H][W]; // 높이 너비
            select = new int[N];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            res = Integer.MAX_VALUE;
            pm(0);
            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    // 중복순열 => 같은 자리 또 떨구기 가능
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

    // 벽돌이 얼마나 깨지나 확인
    static void check() {
        int[][] cboard = copyBoard();

        for (int w : select) {
            visit = new boolean[H][W];

            // 제일 먼저 마주치는 벽돌 찾기
            for (int i = 0; i < H; i++) {
                if (cboard[i][w] == 0) continue;
                q.offer(new int[] {i, w, cboard[i][w]});
                visit[i][w] = true;
                break;
            }

            // 상하좌우 터트리면서 트리거 찾기
            int x, y;
            while (!q.isEmpty()) {
                int[] now = q.poll();
                x = now[0];
                y = now[1];
                cboard[x][y] = 0;

                if (now[2] == 1) continue;

                for (int j = 0; j < 4; j++) {
                    int nx = x;
                    int ny = y;
                    
                    for (int k = 0; k < now[2] - 1; k++) {
                        nx += moves[j][0];
                        ny += moves[j][1];
                        
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
                if (arr[i][j] == 0) continue;
                cnt++; 
            }
        }
        return cnt;
    }

    // 구멍난 맵 메워주기
    static void setBoard(int[][] arr) {
        // 모든 열에 대하여
        // 한칸 씩 올라가면서 갖고 오기
        for (int i = 0; i < W; i++) {
            for (int j = H-1; j >= 0; j--) {
                if (arr[j][i] != 0) continue; 

                for (int k = j - 1; k >= 0; k--) {
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

    // 깊은 복사
    static int[][] copyBoard() {
        int[][] r = new int[H][W];
        for (int i = 0; i < H; i++) r[i] = board[i].clone();
        return r;
    }
}
