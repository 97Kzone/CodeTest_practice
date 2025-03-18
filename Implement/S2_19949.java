package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_19949 {

    static int[] num1, num2;
    static long res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num1 = new int[10];
        num2 = new int[10];

        for (int i = 0; i < 10; i++) {
            num1[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        check(0);

        System.out.print(res);
    }

    static void check(int d) {
        if (d == 10) {
            int cnt = 0;

            for (int i = 0; i < 10; i++) {
                if (num1[i] == num2[i]) cnt++;
            }

            if (cnt >= 5) res++;

            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (d >= 2) {
                if (num2[d-1] == i && num2[d-2] == i) continue;
            }

            num2[d] = i;
            check(d+1);
        }
    }
}
