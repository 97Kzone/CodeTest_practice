package Implement;

import java.util.Scanner;

public class S5_16969 {

    private static final long MOD = 1000000009L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        scanner.close();

        int idx = 0, len = number.length();
        long cases = 1;

        while (idx < len) {
            if (number.charAt(idx) == 'c') {
                int cnt = 0;
                while (idx < len && number.charAt(idx) == 'c') {
                    idx++;
                    cnt++;
                }
                cases = (cases * 26) % MOD;

                int cnt_mul = 1;
                while (cnt_mul < cnt) {
                    cases *= 25;
                    cases %= MOD;
                    cnt_mul++;
                }
            } else {
                int cnt = 0;
                while (idx < len && number.charAt(idx) == 'd') {
                    idx++;
                    cnt++;
                }
                cases = (cases * 10) % MOD;

                int cnt_mul = 1;
                while (cnt_mul < cnt) {
                    cases *= 9;
                    cases %= MOD;
                    cnt_mul++;
                }
            }
        }

        System.out.println(cases);
    }
}
