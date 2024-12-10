package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_14650 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        long res = check(1, 1) + check(1, 2);

        System.out.print(res);
    }
    
    static long check(int cnt, int num) {
        if (cnt == N) {
            return (num % 3 == 0) ? 1 : 0;
        }

        long res = 0;
        int nxt;
        for (int i = 0; i <= 2; i++) {
            nxt = num * 10 + i;
            res += check(cnt + 1, nxt);
        }

        return res;
    }
}
