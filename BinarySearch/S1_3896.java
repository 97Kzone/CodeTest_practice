package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_3896 {

    static int N = 1299710;
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        init();

        int k, l, r;
        for (int t = 0; t < T; t++) {
            k = Integer.parseInt(br.readLine());

            if (isPrime[k]) {
                sb.append(0 + "\n");
                continue;
            }

            l = k;
            r = k;
            while (true) {
                if (isPrime[--l]) break;
            }

            while (true) {
                if (isPrime[++r]) break;
            }
            sb.append(r - l + "\n");
        }
        System.out.print(sb);
    }

    static void init() {
        isPrime = new boolean[N];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
