package Implement;

import java.math.BigInteger;
import java.util.Scanner;

public class S3_2407 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        BigInteger res = new BigInteger(String.valueOf(1));
        for (int i = N; i > N-M; i--) {
            res = res.multiply(new BigInteger(String.valueOf(i)));
        }

        BigInteger tmp = new BigInteger(String.valueOf(1));
        for (int i = 2; i <= M; i++) {
            tmp = tmp.multiply(new BigInteger(String.valueOf(i)));
        }
        
        System.out.println(res.divide(tmp));
    }
}
