package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_4307 {
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            int a, b;
            int min = 0, max = 0;
            for (int i = 0; i < L; i++) {
                a = Integer.parseInt(br.readLine());
                b = Math.min(a, N - a);
                min = Math.max(min, b);

                max = Math.max(a, max);
                max = Math.max(N - a, max);
            }
            System.out.println(min + " " + max);
        }
    }

}
