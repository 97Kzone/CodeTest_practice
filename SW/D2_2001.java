import java.util.*;

public class D2_2001 {
    static int N, M;
    static int res;
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            res = 0;

            board = new int[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            for (int i=0; i<N-M+1; i++) {
                for (int j=0; j<N-M+1; j++) {
                    res = Math.max(res, check(i, j));
                }
            }

            System.out.printf("#%d %d\n", t, res);
        }
    }    

    public static int check(int i, int j) {
        int tmp = 0;
        for (int x=i; x<i+M; x++) {
            for (int y=j; y<j+M; y++) {
                tmp += board[x][y];
            }
        }
        return tmp;
    }
}
