package ACG;

import java.util.Scanner;

public class C {
    static long N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();
        int res = 1;
        long std = 1;

        if (N > 1) {
            while (true) {
                if (N <= std * 2) {
                    res++;
                    break;
                }
    
                std *= 2;
                res++;
            }
        } else
            res = (int)N;

        System.out.print(res);
    }
    
}
