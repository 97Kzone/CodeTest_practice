package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_26169 {

    static int r, c, res;
    static int[][] board;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

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

        check(r, c, 0, 0);
        System.out.print(res);
    }
    
    static void check(int x, int y, int cnt, int move) {
        if (board[x][y] == 1) {
            cnt++;
        }

        if (move == 3) {
            if (cnt > 1)
                res = 1;
            return;
        }
        
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + moves[i][0];
            ny = y + moves[i][1];

            if (!isPossible(nx, ny) || board[nx][ny] == -1) {
                continue;
            }

            board[x][y] = -1;
            check(nx, ny, cnt, move + 1);
            board[x][y] = 0;
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < 5) && (0 <= y && y < 5);
    }
}