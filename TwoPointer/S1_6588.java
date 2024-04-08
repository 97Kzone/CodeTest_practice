package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_6588 {

    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        init();

        int std = 0;
        while (true) {
            std = Integer.parseInt(br.readLine());

            if (std == 0) break;

            for (int i = 2; i <= std / 2; i++) {
                if (isPrime[i] && isPrime[std - i]) {
                    sb.append(std + " = " + i + " + " + (std - i) + "\n");
                    break;
                }
            }
        }
        
        System.out.print(sb);
    }

    static void init() {
        isPrime = new boolean[1000001];
        
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(1000001); i++) {
            if (!isPrime[i]) continue;

            for (int j = i * i; j < 1000001; j += i) {
                isPrime[j] = false;
            }
        }
        
    }
}
