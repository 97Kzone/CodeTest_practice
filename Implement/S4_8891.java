package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S4_8891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int a, b, v1, v2, res1, res2;
        int[] xy1, xy2;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            xy1 = check(a);
            xy2 = check(b);

            v1 = (a + 1 - xy1[1]);
            v2 = (b + 1 - xy2[1]);
            
            res1 = v1 + v2;
            res2 = (xy1[0] + 1 - v1) + (xy2[0] + 1 - v2);

            sb.append(check2(res1 + res2 - 1) + (res1 - 1) + "\n");

        }

        System.out.print(sb);
    }

    static int check2(int n) {
        return 1 + n * (n - 1) / 2;
    }

    static int[] check(int n) {
        int std = 1;

        while (true) {
            if (n == 1) {
                return new int[] { 1, 1 };
            }

            if (check2(std) <= n && n < check2(std + 1)) {
                return new int[] {std, check2(std)};
            } else {
                std++;
            }
        }
    }
}
