package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_15965 {

    static int N, res;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        prime = new boolean[10000001];

        isPrime();
        System.out.print(res);
    }

    static void isPrime() {
        int k = 1;
        int v = 2;

        int n;
        while (k < N) {
            if (prime[v]) {
                v++;
                continue;
            }

            n = 1;
            while (v * n <= 10000000) {
                prime[v * n] = true;
                n++;
            }

            v++;
            while (v <= 10000000 && prime[v]) {
                v++;
            }
            k++;
        }

        res = v;
    }
}
