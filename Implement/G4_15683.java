package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 멍청하면 어쩔수 있나.. 다 해봐야지..
public class G4_15683 {
    static int N, M, res;
    static int[][] board;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우 순
    static ArrayList<int[]> cctv; // CCTV;
    static int[][] dir[] = {{}, {{0}, {1}, {2}, {3}}, {{0, 1}, {2, 3}}, 
                            {{0, 2}, {0, 3}, {1, 2}, {1, 3}}, {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
                            {{0, 1, 2, 3}}}; // CCTV 번호별 가능한 방향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0 || board[i][j] == 6) continue;

                cctv.add(new int[] {i, j, board[i][j]});
            }
        }

        res = Integer.MAX_VALUE;
        dfs(0, board);
        
        System.out.print(res);
    }

    // CCTV 를 순회하며
    static void dfs(int idx, int[][] arr) {
        if (idx == cctv.size()) {
            res = Math.min(res, count(arr));
            return;
        }
        
        
        int[][] cboard = copyBoard(arr); // 현재 맵 복사
        int[] now = cctv.get(idx); // 현재 조작할 CCTV
        
        int x = now[0];
        int y = now[1];
        for (int[] d : dir[now[2]]) {
            check(x, y, d, cboard);
            dfs(idx + 1, cboard); // 다음 CCTV;
            cboard = copyBoard(arr); // 방향 전환을 위해 원본 갖고오기
        }
    }

    // 어디까지 감시 가능할까?
    static void check(int x, int y, int[] d, int[][] arr) {
        int nx, ny;
        for (int i = 0; i < d.length; i++) {
            nx = x;
            ny = y;

            while (true) {
                nx += moves[d[i]][0];
                ny += moves[d[i]][1];

                if (!isPossible(nx, ny)) break; // 범위 벗어나면 끝
                if (arr[nx][ny] == 6) break; // 벽 보면 끝
                if (arr[nx][ny] == 0) arr[nx][ny] = -1;  // 감시 가능
            }
        }
    }
    
    // 맵 깊은 복사
    static int[][] copyBoard(int[][] arr) {
        int[][] res = new int[N][M];
        for (int i = 0; i < N; i++) res[i] = arr[i].clone();
        return res;
    }

    // 사각지대는 몇 칸일까
    static int count(int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    // 범위 체크
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}