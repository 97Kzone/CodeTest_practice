import java.util.Scanner;

public class D3_10032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int res = N%K > 0 ? 1 : 0;
            System.out.printf("#%d %d\n", t, res);
        }
    }
}
