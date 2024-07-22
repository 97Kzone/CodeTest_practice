package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_29717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        long N;
        for (int t = 0; t < T; t++) {
            N = Long.parseLong(br.readLine());

            long l = 1;
            long r = 1000000000;
            long std = (N * (N + 1)) / 2;
            long m;
            while (l <= r) {
                m = (l + r) / 2;
                if (m * (m + 1) <= std) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            sb.append(l + "\n");
        }

        System.out.print(sb);
    }
}
