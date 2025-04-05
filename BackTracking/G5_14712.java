package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_14712 {

    static int N, M;
    static long res;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        res = 0;
        board = new int[N][M];

        check(0, 0);

        System.out.print(res);
    }

    static void check(int x, int y) {
        if (x == N) {
            res++;
            return;
        }

        int nx = (y + 1 == M) ? x + 1 : x;
        int ny = (y + 1) % M;

        check(nx, ny);

        if (isPossible(x, y)) {
            board[x][y] = 1;
            check(nx, ny);
            board[x][y] = 0;
        }
    }

    static boolean isPossible(int x, int y) {
        if (x == 0 || y == 0) return true;

        return !(board[x][y-1] == 1 && board[x-1][y] == 1 && board[x-1][y-1] == 1);
    }
}
