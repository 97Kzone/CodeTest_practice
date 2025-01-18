package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_11561 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long N, l, r;
        for (int t = 0; t < T; t++) {
            N = Long.parseLong(br.readLine());

            l = 0;
            r = 1000000000;

            long res = 0;
            long m, std;
            while (l <= r) {
                m = (l + r) / 2;
                std = (m * (m + 1)) / 2;

                if (std <= N) {
                    res = Math.max(res, m);
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            sb.append(res + "\n");
        }
        System.out.print(sb.toString());
    }
}
