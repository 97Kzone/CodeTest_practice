import java.util.*;

public class D2_1954 {
    static int N, r, c, d, idx;
    static int[][] res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            res = new int[N][N];

            r = 0; 
            c = -1;
            d = 1;
            idx = 1;

            while (N > 0) {
                for (int i=0; i<N; i++) {
                    c += d;
                    res[r][c] = idx;
                    idx += 1;
                }
                N -= 1;

                for (int i=0; i<N; i++) {
                    r += d;
                    res[r][c] = idx;
                    idx += 1;
                }
                d *= -1;
            }

            System.out.printf("#%d\n", t);
            for (int[] n : res) {
                for (int a : n) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
        }
    }    
}
