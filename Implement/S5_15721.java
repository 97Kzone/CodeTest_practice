package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_15721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int std = Integer.parseInt(br.readLine());

        int b = 0, d = 0;
        int n = 2;
        int idx = 0;

        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    b++;
                    if (b == T && std == 0) {
                        System.out.print(idx % A);
                        return;
                    }
                } else {
                    d++;
                    if (d == T && std == 1) {
                        System.out.print(idx % A);
                        return;
                    }
                }
                idx++;
            }

            for (int i = 0; i < n; i++) {
                b++;
                if (b == T && std == 0) {
                    System.out.print(idx % A);
                    return;
                }
                idx++;
            }
            
            for (int i = 0; i < n; i++) {
                d++;
                if (d == T && std == 1) {
                    System.out.print(idx % A);
                    return;
                }
                idx++;
            }
            n++;
        }
    }
}
