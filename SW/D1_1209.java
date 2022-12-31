import java.util.*;

public class D1_1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t=1; t<=10; t++) {
            int v = sc.nextInt();

            int[][] nums = new int[100][100];
            for (int i=0; i<100; i++) {
                for (int j=0; j<100; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }

            int res = 0;
            int v1 = 0, v2 = 0, r, c;
            for (int i=0; i<100; i++) {
                r = 0;
                for (int j=0; j<100; j++) {
                    r += nums[i][j];
                    if (i == j) v1 += nums[i][j];
                    if (i+j == 100) v2 += nums[i][j];
                }
                res = Math.max(res, r);
            }

            for (int i=0; i<100; i++) {
                c = 0;
                for(int j=0; j<100; j++) {
                    c += nums[j][i];
                }
                res = Math.max(res, c);
            }

            res = Math.max(res, v1);
            res = Math.max(res, v2);

            System.out.printf("#%d %d\n", t, res);
        }

    }
}
