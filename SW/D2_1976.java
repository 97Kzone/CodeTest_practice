import java.util.*;

public class D2_1976 {
    static int a, b, c, d;
    static int div, mod;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            d = sc.nextInt();
            
            div = (b+d) / 60;
            mod = (b+d) % 60;

            int tmp = (a+c+div)%12;
            int res = 0;
            if (tmp == 0) {
                res = 12;
            } else {
                res = tmp;
            }

            System.out.printf("#%d %d %d", t, res, mod);
            
        }
    }
}