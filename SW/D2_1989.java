import java.util.*;

public class D2_1989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for (int t=1; t<=T; t++) {
            String s = sc.nextLine();
            StringBuffer sb = new StringBuffer(s);
            String s2 = sb.reverse().toString();

            int res = 0;
            if (s.equals(s2)) res = 1;

            System.out.printf("#%d %d\n", t, res);
        }
    }    
}
