package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int l = 0, r = 0;
        int sum = 0, res = 0;
        while (l <= N) {
            while (++r <= N) {
                sum += r;
                if (sum >= N) {
                    if (sum == N)
                        res++;
                    break;
                }
            }

            while (++l <= N) {
                sum -= l;
                if (sum <= N) {
                    if (sum == N)
                        res++;
                    break;
                }
            }
        }
        System.out.print(res);
    }
}
