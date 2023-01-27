import java.util.Scanner;

public class D3_5601 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();

            System.out.printf("#%d ", t);
            for (int i = 0; i < N; i++) {
                System.out.printf("1/%d ", N);
            }
            System.out.println();
        }
    }
}
