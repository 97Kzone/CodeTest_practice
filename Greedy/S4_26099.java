package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_26099 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long N = Integer.parseInt(br.readLine());
        long res = N / 5;
        long mod = N % 5;

        if (res == 0 && mod == 4 || res < 2 && mod == 2) {
            res = -1;
        } else {
            res += mod / 3;
            mod %= 3;
            res += mod;
        }
        
        System.out.print(res);
    }
}
