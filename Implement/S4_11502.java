package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S4_11502 {

    static final int MAX = 1000;
    static boolean[] isPrime;
    static List<Integer> primes;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();

        int T = Integer.parseInt(br.readLine());

        int K;
        int a, b, c;
        boolean flag;
        for (int t = 0; t < T; t++) {
            K = Integer.parseInt(br.readLine());

            flag = false;
            for (int i = 0; i < primes.size(); i++) {
                if(flag) break;
                a = primes.get(i);

                for (int j = i; j < primes.size(); j++) {
                    if (flag) break;
                    b = primes.get(j);

                    for (int k = j; k < primes.size(); k++) {
                        c = primes.get(k);
                        if (a + b + c == K) {
                            sb.append(a + " " + b + " " + c + "\n");
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }  
        
        System.out.print(sb.toString());
    }

    static void init() {
        isPrime = new boolean[MAX + 1];
        primes = new ArrayList<>();

        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) continue;
            for (int j = i * i; j <= MAX; j += i) {
                isPrime[j] = true;
            }
        }

        for (int i = 2; i <= MAX; i++) {
            if(!isPrime[i]) primes.add(i);
        }
    }
}
