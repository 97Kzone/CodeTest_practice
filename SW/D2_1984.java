import java.util.Scanner;

public class D2_1984 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t=1; t<=T; t++) {
            int n = 1000000;
            int m = 0, sum = 0;
            for (int i=0; i<10; i++) {
                int num = sc.nextInt();

                m = Math.max(m, num);
                n = Math.min(n, num);
                
                sum += num;
            }
            System.out.printf("#%d %.0f\n", t, (sum-m-n) / 8.0);
        }
    }
}
