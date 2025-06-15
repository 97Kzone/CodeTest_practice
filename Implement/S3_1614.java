package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_1614 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        long M = Long.parseLong(br.readLine());

        long res = 0;
        if (M < 1) {
            res = N - 1;
        } else {
            res += 5;

            if (N != 1 && N != 5) res += (M-1) * 4;
            else if (N == 1 || N == 5) res += (M - 1) * 4 * 2;

            if (N == 1) res += 3;
            else if (N == 5) res += 7;
            else if (M % 2 == 0) res += N - 2;
            else if (M % 2 != 0) res += 4 - N;
        }

        System.out.print(res);
    }
}