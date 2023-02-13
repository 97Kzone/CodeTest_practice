package Tree;

import java.util.Scanner;

public class P5_11025 {
    static int N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = (res + K) % i;
            System.out.print(res + " ");
        }
    }
}
