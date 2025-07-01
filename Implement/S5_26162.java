package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S5_26162 {
    
    static int N;
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        init();

        N = Integer.parseInt(br.readLine());
        int num;
        boolean flag;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            
            flag = false;
            for (int j = 2; j <= num / 2; j++) {
                if (prime[j] && prime[num - j]) {
                    sb.append("Yes").append("\n");
                    flag = true;
                    break;
                }
            }

            if (!flag) sb.append("No").append("\n");
        }

        System.out.print(sb.toString());
    }

    static void init() {
        prime = new boolean[119];
        Arrays.fill(prime, true);
        prime[1] = false;

        for (int i = 2; i < 119; i++) {
            if(prime[i]) {
                for (int j = i + i; j < 119; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
