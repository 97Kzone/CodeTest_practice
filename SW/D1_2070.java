import java.util.Scanner;

public class D1_2070 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=1; t <= T; t++) {
            String res = "";

            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a > b) {
                res = ">";
            } else if (a == b) {
                res = "=";
            } else {
                res = "<";
            }

            System.out.printf("#%d %s\n", t, res);
        }
        sc.close();
    }
}
