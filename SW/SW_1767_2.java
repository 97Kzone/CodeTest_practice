import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_1767_2 {
    static int N, res, size;
    static boolean[] select;
    static ArrayList<int[]> cores;
    static int[][] board;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            cores = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (i == 0 || i == N-1 || j == 0 || j == N-1) continue;
                    if (board[i][j] == 0) continue;
                    
                    cores.add(new int[] {i, j});
                }
            }
            
            res = 987654321;
            size = cores.size();
            select = new boolean[size];
            for (int i = cores.size(); i > 0; i--) {
                if (res != 987654321) break;
                cb(0, 0, i);
            }

            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    // 조합
    static void cb(int cnt, int start, int M) {
        if (cnt == M) {
            check(0, 0, board);
            return;
        }

        for (int i = start; i < size; i++) {
            select[i] = true;
            cb(cnt + 1, i + 1, M);
            select[i] = false;
        }
    }
    
    // 프로세스 연결해보기
    static void check(int idx, int cnt, int[][] arr) {
        if (idx == size) {
            res = Math.min(res, cnt);
            return; // 기저조건
        }

        if (!select[idx]) {
            check(idx + 1, cnt, arr);
            return;
        }

        int[][] cboard;
        
        int x = cores.get(idx)[0];
        int y = cores.get(idx)[1];

        for (int i = 0; i < 4; i++) {
            int v = 0;
            cboard = copyBoard(arr);
            
            int nx = x;
            int ny = y;
            
            while(true) {
                nx += moves[i][0];
                ny += moves[i][1];
                
                if(!isPossible(nx, ny)) {
                    check(idx + 1, cnt + v, cboard);
                    break;
                }

                if (cboard[nx][ny] != 0) break; // 코어 or 선이 존재
                cboard[nx][ny] = -1;
                v++;
            }
        }

    }

    static int[][] copyBoard(int[][] arr) {
        int[][] r = new int[N][N];
        for (int i = 0; i < N; i++) r[i] = arr[i].clone();
        return r;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}
