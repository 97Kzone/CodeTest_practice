package Implement;

import java.util.Arrays;
import java.util.Scanner;

public class G1_1019 {
    static int[] nums;
    static int v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = 1;
        int e = sc.nextInt();
        v = 1;

        nums = new int[10];

        while (s <= e) {
            while (s % 10 != 0 && s <= e) {
                check(s++);
            }

            if (s > e) break;

            while (e % 10 != 9 && s <= e) {
                check(e--);
            }

            int tmp = (e / 10) - (s / 10) + 1;
            for (int i = 0; i < 10; i++) {
                nums[i] += (tmp * v);
            }

            v *= 10;
            s /= 10;
            e /= 10;
        }

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    static void check(int n) {
        for (int i = n; i > 0; i /= 10) {
            String s = Integer.toString(i);
            nums[s.charAt(s.length() - 1) - '0'] += v;
        }
    }
}
