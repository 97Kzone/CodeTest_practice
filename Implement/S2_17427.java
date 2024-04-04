package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_17427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long res = 0;
        for (int i = 1; i <= N; i++) {
            res += i * (N / i);
        }

        System.out.print(res);
    }
}
