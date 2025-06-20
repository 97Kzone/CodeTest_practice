package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_15979 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Math.abs(Integer.parseInt(st.nextToken()));
        N = Math.abs(Integer.parseInt(st.nextToken()));

        if (M == 0 && N == 0) {
            System.out.print(0);
            return;
        } else if (gcd(N, M) == 1) {
            System.out.print(1);
            return;
        } else {
            System.out.print(2);
            return;
        }
    }

    static int gcd(int a, int b) {
        int tmp;
        while (b != 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}
