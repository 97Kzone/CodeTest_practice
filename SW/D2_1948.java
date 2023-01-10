import java.util.*;

public class D2_1948 {
    static int[] std = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int m1, d1, m2, d2, res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            m1 = sc.nextInt();
            d1 = sc.nextInt();
            m2 = sc.nextInt();
            d2 = sc.nextInt();

            res = 0;
            while (true) {
                if (m1 < m2) {
                    res += std[m1];
                    m1 += 1;
                    continue;
                }

                if (m1 == m2) res += d2; break;
            }

            System.out.printf("#%d %d\n", t, res+1-d1);
        }
    }        
}
