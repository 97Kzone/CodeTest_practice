package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_20548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long c = Long.parseLong(br.readLine());
        long res = 0;

        long std = 1;
        while (c > 0) {
            res += c % 7 * std;
            c /= 7;
            std *= 3;
        }

        System.out.print(res);
    }
}
