package KSA2023;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N <= 2) {
            N = 4;
        }
        else if (N % 2 != 0) {
            N += 1;
        }

        System.out.print(N);
    }
}
