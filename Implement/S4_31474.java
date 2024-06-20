package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class S4_31474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        N /= 2;

        BigInteger res = BigInteger.valueOf(1);

        for (int i = 1; i <= N * 2 - 1; i += 2) {
            res = res.multiply(BigInteger.valueOf(i));
        }

        System.out.print(res);
    }
}
