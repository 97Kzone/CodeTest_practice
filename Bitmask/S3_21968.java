package Bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_21968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long N, v, res;
        for (int t = 0; t < T; t++) {
            N = Long.parseLong(br.readLine());
            v = 1;
            res = 0;

            while (0 < N) {
                if ((N & 1) == 1) res += v;
                v *= 3;
                N >>= 1;
            }

            sb.append(res + "\n");
        }
        System.out.print(sb);
    }
}
