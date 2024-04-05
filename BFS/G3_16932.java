package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class G3_16932 {

    static int N, M;
    static int[][] board;
    static Map<Integer, Integer> map;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = -Integer.parseInt(st.nextToken());
            }
        }

        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == -1) {
                    check(idx, i, j);
                    idx++;
                }
            }
        }

        int res = 0;
        int nx, ny, cnt;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            cnt = 0;
            
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) continue;
                
                cnt = 0;
                set.clear();
                for (int[] move : moves) {
                    nx = i + move[0];
                    ny = j + move[1];

                    if (!isPossible(nx, ny) || board[nx][ny] == 0)
                        continue;
                    set.add(board[nx][ny]);
                }
                
                for (int key : set) cnt += map.get(key);
                res = Math.max(res, cnt);
            }
        }
        
        System.out.print(res + 1);
    }
    
    static void check(int idx, int x, int y) {
        int cnt = 1;
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[] { x, y });
        board[x][y] = idx;
        
        int[] now;
        int nx, ny;
        while (!q.isEmpty()) {
            now = q.poll();

            for (int[] move : moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];

                if (!isPossible(nx, ny))
                    continue;

                if (board[nx][ny] == -1) {
                    board[nx][ny] = idx;
                    q.offer(new int[] { nx, ny });
                    cnt++;
                }
            }
        }
        
        map.put(idx, cnt);
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
