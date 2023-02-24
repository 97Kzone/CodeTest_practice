package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 조합 + BFS + 시뮬레이션
public class G3_17135 {
    static int N, M, D, res;
    static int[] arr; // 궁수 좌표
    static int[][] board, board2; // 맵
    static Set<int[]> kill; // 잡을 수 있는 적 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        board = new int[N][M]; 
        arr = new int[3]; // 궁수 배치할 열

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        res = 0;
        cb(0, 0);
        System.out.println(res);
    }

    // 궁수를 어디에 배치할까?
    static void cb(int cnt, int start) {
        if (cnt == 3) {
            check();
            return;
        }

        for (int i = start; i < M; i++) {
            arr[cnt] = i;
            cb(cnt + 1, i + 1); 
        }
    }

    // 잡을 수 있는 적 탐색
    static void check() {
        int cnt = 0;
        board2 = board.clone();

        // N번 해야한다.
        for (int t = 0; t < N; t++) {

            kill = new HashSet<>();
            // 왼쪽 궁수부터 적을 탐색
            for (int i = 0; i < 3; i++) {

                //왼쪽 부터 탐색
                loop:
                for (int j = N - 1; j > N - 1 - D; j--) {
                    int s = arr[i] - D < 0 ? 0 : arr[i] - D;
                    int e = arr[i] + D >= M ? M : arr[i] + D;
                    for (int k = s; k < e; k++) {
                        System.out.println(j + " " + k);
                        if (dist(arr[i], j, k) > D) continue; // 사거리 밖
                        if (board[j][k] == 1) {
                            kill.add(new int[] {j, k});
                            break loop;
                        }
                    }
                }
            }

            // 중복 되는 적 포함 처리
            cnt += kill.size();
            for (int[] p : kill) board2[p[0]][p[1]] = 0;

            setBoard();
        }
        res = Math.max(res, cnt);
    }

    // 한 칸씩 당겨오기
    static void setBoard() {
        for (int i = N - 1; i > 0; i--) board2[i] = board2[i-1];
        Arrays.fill(board2[0], 0);
    }

    // 거리 계산
    static int dist(int i, int j, int k) {
        return Math.abs(N - j) + Math.abs(i - k);
    }
}
