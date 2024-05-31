package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_4134 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long n;
        for (int t = 0; t < T; t++) {
            n = Long.parseLong(br.readLine());

            sb.append(check(n) + "\n");
        }

        System.out.print(sb);
    }
    
    static long check(long n) {
        long res;

        if (n == 0 || n == 1) {
            return 2;
        }

        while (true) {
            res = 0;
            
            for (long i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    res++;
                    break;
                }
            }
            if (res == 0) return n;
            n++;
        }
    }
}
