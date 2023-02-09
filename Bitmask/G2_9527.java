package Bitmask;

import java.util.ArrayList;
import java.util.Scanner;

public class G2_9527 {
    static long A, B;
    static ArrayList<Long> arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextLong();
        B = sc.nextLong();
        arr = new ArrayList<>();
        arr.add(1L);

        long n = 1;

        for (int i = 0; i < 55; i++) {
            arr.add(arr.get(arr.size() - 1) * 2 + n * 2);
            n <<= 1;
        }

        System.out.println(check(B) - check(A-1));
    }

    static long check(long num) {
        if (num <= 1) return num;
        int j = 0;
        long i;
        for (i = 2L; i * 2 <= num; i <<= 1) j++;
        
        return arr.get(j) + num - i + 1 + check(num - i);
    }
}
