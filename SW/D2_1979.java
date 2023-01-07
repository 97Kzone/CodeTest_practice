import java.util.*;

public class D2_1979 {
    static int N, K;
    static int[][] board;
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            
            board = new int[N][N];
            
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int cnt, res = 0;
            for (int i=0; i<N; i++) {
                cnt = 0;
                for (int j=0; j<N; j++) {
                    if (board[i][j] == 1) {
                        cnt += 1;
                    } else {
                        if (cnt == K) res += 1;
                        cnt = 0;
                    }
                }

                if (cnt == K) res += 1;
            }

            for (int i=0; i<N; i++) {
                cnt = 0;
                for (int j=0; j<N; j++) {
                    if (board[j][i] == 1) {
                        cnt += 1;
                    } else {
                        if (cnt == K) res += 1;
                        cnt = 0;
                    }
                }
                if (cnt == K) res += 1;
            }

            System.out.printf("#%d %d\n", t, res);
        }
    }
}
