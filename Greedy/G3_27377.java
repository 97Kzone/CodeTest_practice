package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class G3_27377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        long N;
        BigInteger s, t, res;
        for (int a = 0; a < T; a++) {
            N = Long.parseLong(br.readLine());

            st = new StringTokenizer(br.readLine());
            s = new BigInteger(st.nextToken());
            t = new BigInteger(st.nextToken());
            res = BigInteger.ZERO;

            while (N != 0) {
                if (N % 2 == 1) {
                    N -= 1;
                    res = res.add(s);
                } else {
                    BigInteger tmp = new BigInteger(String.valueOf(N));
                    if (tmp.multiply(s).divide(BigInteger.TWO).compareTo(t) > 0) {
                        res = res.add(t);
                    } else {
                        res = res.add(s.multiply(tmp.divide(BigInteger.TWO)));
                    }
                    N /= 2;
                }
            }

            sb.append(res + "\n");
        }
        System.out.print(sb.toString());
    }
}
