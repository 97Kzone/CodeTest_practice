package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_12755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        int std, tmp;
        while (N > 0) {
            std = 0;
            cnt++;

            tmp = cnt;
            while (tmp > 0) {
                std++;
                tmp /= 10;
            }

            N -= std;
        }

        std = Math.abs(N);
        int res = 0;
        for (int i = 0; i <= std; i++) {
            res = cnt % 10;
            cnt /= 10;
        }

        System.out.print(res);
    }
}
