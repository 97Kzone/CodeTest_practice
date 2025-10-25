package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_25513 {

    static int r, c, res;
    static int[][] board;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        res = 0;
        boolean flag = true;
        for (int i = 1; i <= 6; i++) {
            if(!check(i)) {
                flag = false;
                break;
            }
        }

        System.out.print(flag ? res : -1);
    }

    static boolean check(int std) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        pq.offer(new int[] {r, c, 0});
        
        boolean[][] visit = new boolean[5][5];
        visit[r][c] = true;

        int[] now;
        int x, y, nx, ny;
        while(!pq.isEmpty()) {
            now = pq.poll();
            x = now[0];
            y = now[1];

            if (board[x][y] == std) {
                r = x;
                c = y;
                res += now[2];
                return true;
            }

            for (int[] move : moves) {
                nx = x + move[0];
                ny = y + move[1];

                if(!isPossible(nx, ny)) continue;
                if(board[nx][ny] == -1 || visit[nx][ny]) continue;
                
                
                visit[nx][ny] = true;
                pq.offer(new int[] {nx, ny, now[2] + 1});
            }
        }

        return false;
    }
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < 5) && (0 <= y && y < 5);
    }
}
