import java.util.*;

public class D2_1961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            int[][] board = new int[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            
            int[][] v1 = rotate(board);
            int[][] v2 = rotate(v1);
            int[][] v3 = rotate(v2);

            System.out.printf("#%d\n", t);

            check(v1, v2, v3);
        }
    }
    public static int[][] rotate(int[][] board) {
        int n = board.length;
        int[][] tmp = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                tmp[j][n-1-i] = board[i][j]; 
            }
        }
        return tmp;
    }

    public static void check(int[][] arr, int[][] arr2, int[][] arr3) {
        int N = arr.length;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.print(" ");
            for (int j=0; j<N; j++) {
                System.out.print(arr2[i][j]);
            }
            System.out.print(" ");
            for (int j=0; j<N; j++) {
                System.out.print(arr3[i][j]);
            }
            System.out.println();
        }
    }
}
