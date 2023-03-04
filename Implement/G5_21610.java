package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G5_21610 {
    static int N, M, res;
    static int[][] board, visit;
    static ArrayList<int[]> cloud, pos;
    static int[][] moves = {{}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1},
                            {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        cloud = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 구름
        for (int i = 0; i < 2; i++) {
            cloud.add(new int[] {N-i-1, 0});
            cloud.add(new int[] {N-i-1, 1});
        }
 
        int d, s;
        // M번의 커맨드
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            move(d, s); // 1. 구름 이동 + 물 복사 버그
        }
        
        // 남은 물은 얼마나 있을까...
        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += board[i][j];
            }
        }

        System.out.print(res);
    }

    static void move(int d, int s) {
        pos = new ArrayList<>();
        visit = new int[N][N];
        // 1. 구름 이동
        int x, y;
        for (int i = 0; i < cloud.size(); i++) {
            x = Math.floorMod((cloud.get(i)[0] + moves[d][0] * s), N);
            y = Math.floorMod((cloud.get(i)[1] + moves[d][1] * s), N);
            
            board[x][y]++;
            visit[x][y]++;

            pos.add(new int[] {x, y});
        }
        cloud.clear(); // 구름 초기화

        int cnt, nx, ny;
        // 2. 물 복사 버그
        for (int i = 0; i < pos.size(); i++) {
            x = pos.get(i)[0];
            y = pos.get(i)[1];

            cnt = 0;
            // 대각선 확인
            for (int j = 2; j < 9; j += 2) {
                nx = x + moves[j][0];
                ny = y + moves[j][1];

                if (!isPossible(nx, ny)) continue;
                if (board[nx][ny] != 0) cnt++;
            }

            board[x][y] += cnt;
        }

        // 3. 새로운 구름의 탄생
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] < 2 || visit[i][j] == 1) continue;
                board[i][j] -= 2;
                cloud.add(new int[] {i, j});
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}