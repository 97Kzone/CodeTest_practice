import java.util.*;

public class D3_15758J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t=1; t<=T; t++) {
            String[] s = sc.nextLine().split(" ");
            int la = s[0].length();
            int lb = s[1].length();
            int v = (la * lb) / gcd(la, lb);
            
            String s1 = "", s2 = "";
            for (int i=0; i<v/la; i++) {
                s1 += s[0];
            }

            for (int i=0; i<v/lb; i++) {
                s2 += s[1];
            }

            String res;
            if (s1.equals(s2)) {
                res = "yes";
            } else {
                res = "no";
            }

            System.out.printf("#%d %s\n", t, res);
        }
        sc.close();
    }

    public static int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1%num2);
    }
}
