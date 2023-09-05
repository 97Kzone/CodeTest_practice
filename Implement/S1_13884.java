package Implement;

import java.util.Scanner;

public class S1_13884 {

    public static void test(Scanner sc) {
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] a = new int[N + 1];

        for (int i = 1; i <= N; i++)
            a[i] = sc.nextInt();

        a[0] = 2000000000;
        int h = 0;
        int i, m;
        for (i = 0; i < N; i++) {
            m = 0;
            for (int j = N; j >= 1; j--) {
                if (a[j] < a[m])
                    m = j;
                else if (a[j] == a[m]) {
                    if (j > h)
                        m = j;
                }
            }
            if (m < h)
                break;
            h = m;
            a[m] = 2000000000;
        }
        System.out.println(K + " " + (N - i));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            test(sc);
        }
        sc.close();
    }
}