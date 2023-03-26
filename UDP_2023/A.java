package UDP_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static int N, d, p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        d = 0;
        p = 0;

        String w;
        for (int i = 0; i < N; i++) {
            w = br.readLine();

            if (w.equals("D"))
                d++;
            else
                p++;

            if (Math.abs(d - p) == 2)
                break;
        }
        System.out.println(d + ":" + p);
    }
}
