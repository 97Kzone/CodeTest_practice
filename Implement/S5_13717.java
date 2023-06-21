package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_13717 {
    static int N, res;
    static String res2 = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        res = 0;

        String name;
        int std = 0;

        int a, b, c, d;
        for (int i = 0; i < N; i++) {
            name = br.readLine();
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // 한계치까지
            c = 0;
            while (true) {
                if (b / a == 0)
                    break;

                d = b / a;
                c += d;
                b = b % a + (d * 2);
            }

            if (c > std) {
                std = c;
                res2 = name;
            }

            res += c;
        }

        System.out.println(res);
        System.out.println(res2);
    }
}
