package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_20411 {

    static int M, S, X1, X2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        X1 = Integer.parseInt(st.nextToken());
        X2 = Integer.parseInt(st.nextToken());

        int std = (int) (((long) (X1 - X2) * check(S - X1, M)) % M);
        if (std < 0) std += M;
        int res = (X1 - (int) ((long) std * S % M) + M) % M;

        System.out.print(std + " " + res);
    }

    static int check(int a, int b) {
        int res = 1;
        int tmp = b - 2;

        a %= b;
        while (tmp > 0) {
            if ((tmp & 1) == 1) res = (int) ((long) res * a % b);
            a = (int) ((long) a * a % b);
            tmp >>= 1;
        }
        return res;
    }
}
