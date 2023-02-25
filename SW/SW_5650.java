import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

// 흥미로운 문제
public class SW_5650 {
    static int N, res;
    static int[][] board;
    static HashMap<Integer, ArrayList<int[]>> hole; // 웜홀...
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int[][] dir = {{}, 
                          {1, 3, 0, 2}, // 1번 블록
                          {3, 0, 1, 2}, // 2번 블록
                          {2, 0, 3, 1}, // 3번 블록
                          {1, 2, 3, 0}, //4번 블록
                          {1, 0, 3, 2} // 5번 블록
                        };
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());

            board = new int[N][N];
            hole = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());

                    if (board[i][j] < 6) continue;
                    
                    // 웜홀 체크
                    if (hole.containsKey(board[i][j])) hole.get(board[i][j]).add(new int[] {i, j});
                    else {
                        ArrayList<int[]> tmp = new ArrayList<>();
                        tmp.add(new int[] {i, j});
                        hole.put(board[i][j], tmp);
                    }
                }
            }
            res = 0;
            start(); // 시작

            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    // 출발 지점에서 상, 하, 좌, 우 발사
    static void start() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) continue;
                
                for (int k = 0; k < 4; k++) check(i, j, k); // 좌표, 방향 출발
            }
        }
    }

    // 시뮬레이션 시작
    static void check(int x, int y, int d) {
        int cnt = 0;

        int nx = x;
        int ny = y;

        while (true) {
            nx += moves[d][0];
            ny += moves[d][1];
            // 맵 밖을 나갔으면 ? => 벽 취급 + 방향전환
            if (!isPossible(nx, ny)) {
                d = dir[5][d];
                cnt++;
                continue;
            }

            // 종료조건 1. 출발 위치로 돌아오거나 2. 블랙홀
            if (nx == x && ny == y || board[nx][ny] == -1) {
                res = Math.max(res, cnt);
                return;
            }

            if (board[nx][ny] == 0) continue; // 맨땅이면 지나간다
            if (board[nx][ny] < 6) {
                d = dir[board[nx][ny]][d]; // 방향전환
                cnt++; 
            } else { // 웜홀 => 좌표 이동
                for (int[] xy : hole.get(board[nx][ny])) {
                    if (nx == xy[0] && ny == xy[1]) continue;
                    nx = xy[0];
                    ny = xy[1];
                    break;
                }
            }
        }
    }

    // 맵 밖이면 벽으로 취급
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}
