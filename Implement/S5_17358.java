package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_17358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()) - 1;
        
        long res = 1;
        for (int i = N; i > 0; i -= 2) {
            res = (res * i) % 1_000_000_007;
        }

        System.out.print(res);
    }
}
