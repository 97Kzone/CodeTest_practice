package Implement;

import java.util.*;
import java.io.*;

public class S4_2960 {

    static int N, K;
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        int res = check();
        System.out.print(res);
    }
    
    static int check() {
        for (int i = 2; i <= N; i++) {
            if (!isPrime[i])
                continue;

            for (int j = i; j <= N; j+=i) {
                if (isPrime[j]) {
                    isPrime[j] = false;
                    K--;

                    if (K == 0) {
                        return j;
                    }
                }
            }
        }

        return -1;
    }
}
