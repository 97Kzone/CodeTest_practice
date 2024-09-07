package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class S4_29719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BigInteger mod = BigInteger.valueOf(1000000007);
        BigInteger baseM = BigInteger.valueOf(M);
        BigInteger baseM1 = BigInteger.valueOf(M - 1);

        BigInteger v1 = baseM.modPow(BigInteger.valueOf(N), mod);
        BigInteger v2 = baseM1.modPow(BigInteger.valueOf(N), mod);

        BigInteger res = v1.subtract(v2).mod(mod);

        System.out.println(res);
    }
}
