import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_2105 {
    static int N, res;
    static int[][] board;
    static boolean[] visit;
    static int[][] moves = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}}; // 시계방향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            board = new int[N][N];
            visit = new boolean[101]; // 1 ~ 100 

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    check(i, j); // i, j 좌표에서 출발
                }
            }
            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }
    
    static void check(int x, int y) {
        int nx, ny;
        boolean flag;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (!isPossible(x, y, i, j)) continue; // 범위 밖이면 PASS
                if ((i + j) * 2 < res) continue; // 최대 둘레보다 작으면 PASS
                
                Arrays.fill(visit, false); // 배열 초기화
                nx = x;
                ny = y;
                flag = true;

                // 시계방향
                // 우하
                for (int k = 0; k < i; k++) {
                    nx += moves[0][0];
                    ny += moves[0][1];

                    if(!isVisit(nx, ny)) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) continue;
                // 좌하
                for (int k = 0; k < j; k++) {
                    nx += moves[1][0];
                    ny += moves[1][1];

                    if(!isVisit(nx, ny)) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) continue;
                // 좌상
                for (int k = 0; k < i; k++) {
                    nx += moves[2][0];
                    ny += moves[2][1];

                    if(!isVisit(nx, ny)) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) continue;
                // 우상
                for (int k = 0; k < j; k++) {
                    nx += moves[3][0];
                    ny += moves[3][1];

                    if(!isVisit(nx, ny)) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) continue;
                res = (i + j) * 2;
            }
        }
    }

    static boolean isVisit(int x, int y) {
        if (!visit[board[x][y]]) return visit[board[x][y]] = true;
        return false;
    }

    static boolean isPossible(int x, int y, int i, int j) {
        return  (y + i < N) && (x + i + j < N) && (y - j >= 0);
    }
}
