package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class S4_13706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());

        BigInteger l = new BigInteger("1");
        BigInteger r = N;
        BigInteger m;

        while (true) {
            m = l.add(r).divide(new BigInteger("2"));

            int res = (m.multiply(m)).compareTo(N);
            if (res == 0)
                break;

            if (res == 1) r = m.subtract(new BigInteger("1"));
            else l = m.add(new BigInteger("1"));
        }
        
        System.out.print(m.toString());
    }
}
