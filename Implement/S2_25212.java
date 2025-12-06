package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_25212 {

    static int N;
    static double[] std;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        std = new double[N];

        st = new StringTokenizer(br.readLine());
        int v;
        for (int i = 0; i < N; i++) {
            v = Integer.parseInt(st.nextToken());
            std[i] = 1.0 / v;
        }

        int res = 0;
        double tmp;
        for (int i = 1; i < (1 << N); i++) {
            tmp = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) tmp += std[j];
            }

            if (tmp >= 0.99 && tmp <= 1.01) {
                res++;
            }
        }

        System.out.print(res);
    }
}
