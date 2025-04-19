package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S2_9020 {

    static int T;
    static boolean[] isPrime;
    static List<Integer> prime;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();
        int n, a, b;

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());

            a = n / 2;
            b = n / 2;

            while(true) {
                if (isPrime[a] && isPrime[b]) {
                    sb.append(a + " " + b + "\n");
                    break;
                }

                a--;
                b++;
            }
        }         

        System.out.print(sb.toString());
    }

    static void init() {
        isPrime = new boolean[10001];
        prime = new ArrayList<>();

        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= 10000; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= 10000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= 10000; i++) {
            if(isPrime[i]) prime.add(i);
        }
    }
}
