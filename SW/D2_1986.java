import java.util.*;

public class D2_1986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t=1; t<=T; t++) {
            int N = sc.nextInt();
            int res = 0;
            for (int i=1; i<=N; i++) {
                if (i%2 == 0) {
                    res -= i;
                } else {
                    res += i;
                }
            }

            System.out.printf("#%d %d\n", t, res);
        }
    }    
}
