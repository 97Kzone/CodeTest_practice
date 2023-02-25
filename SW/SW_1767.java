import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
 * 기본전략
 * 최대한 많은 코어를 연결 (벽면 코어는 취급 X)
 */
public class SW_1767 {
    static int N, res, size; 
    static int[][] board;
    static boolean[] select;
    static ArrayList<int[]> cores;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());

            board = new int[N][N];
            cores = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());

                    if (board[i][j] == 0) continue; // 코어가 아니면 pass
                    if (i == 0 || i == N-1 || j == 0 || j == N-1) continue; // 벽면에 붙은 코어는 pass
                    cores.add(new int[] {i, j});
                }
            }

            res = 987654321;
            size = cores.size();
            select = new boolean[size];

            for (int i = size; i > 0; i--) {
                if (res != 987654321) break; // i개 연결된 케이스 확인
                cb(0, 0, i);
            }
            
            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }
    
    static void cb(int cnt, int start, int r) {
        if (cnt == r) {
            check(0, 0, board);
            return;
        }

        for (int i = start; i < size; i++) {
            select[i] = true;
            cb(cnt + 1, i + 1, r);
            select[i] = false;
        }
    }

    static void check(int idx, int cnt, int[][] arr) {
        if (idx == size) {
            res = Math.min(res, cnt);
            return;
        }

        if (!select[idx]) {
            check(idx + 1, cnt, arr);
            return;
        }

        int[] core = cores.get(idx);
        int nx, ny;
        boolean flag;
        int[][] cboard;

        for (int i = 0; i < 4; i++) {
            int v = 0;
            nx = core[0];
            ny = core[1];
            flag = false;
            cboard = deepCopy(arr);
            
            while (true) {
                nx += moves[i][0];
                ny += moves[i][1];

                if(!isPossible(nx, ny)) {
                    flag = true;
                    break;
                }

                if(cboard[nx][ny] != 0) break;
                cboard[nx][ny] = -1;
                v++;
            }

            if (flag) check(idx + 1, cnt + v, cboard);
        }
    }

    static int[][] deepCopy(int[][] arr) {
        int[][] r = new int[N][N];
        for (int i = 0; i < N; i++) r[i] = arr[i].clone();
        return r;
    } 
    
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}
