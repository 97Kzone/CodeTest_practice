import java.util.*;

public class D2_1979 {
    static int N, K;
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            
            board = new int[N][N];
            int[] check = new int[N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int res = 0;
            for (int i=0; i<N; i++) {
                int cnt = 0;
                for (int j=0; j<N; j++) {
                    if (board[i][j] == 1) {
                        cnt += 1;
                        check[j] = cnt;
                    } else {
                        cnt = 0;
                        check[j] = 0;
                    }
                }

                for (int j : check) {
                    System.out.println(j);
                }
            }

            
        }
    }    
}
