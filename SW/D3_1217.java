import java.util.Scanner;

public class D3_1217 {
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int tmp = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();

            res = N;
            check(N, M-1);
            System.out.printf("#%d %d\n", t, res);
        }
    }

    static void check(int n, int d) {
        if (d == 0) return;
        res *= n;
        check(n, d-1);
    }
}
