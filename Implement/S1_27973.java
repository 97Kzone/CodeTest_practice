package Implement;

import java.util.Scanner;

public class S1_27973 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        long min_val = 1; // 가장 작은 정수
        long step = 1; // 각 수 사이의 간격

        for (int i = 0; i < Q; i++) {
            int order = sc.nextInt();
            if (order == 0) {
                int x = sc.nextInt();
                min_val += x;
            } else if (order == 1) {
                int x = sc.nextInt();
                step *= x;
                min_val *= x;
            } else if (order == 2) {
                int x = sc.nextInt();
                min_val += step * x;
            } else {
                System.out.println(min_val);
            }
        }

        sc.close();
    }
}
