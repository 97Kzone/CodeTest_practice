package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_1817 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int res = 0;
        int std = 0;

        if (N != 0) {
            st = new StringTokenizer(br.readLine());
        }

        int v;
        for (int i = 0; i < N; i++) {
            v = Integer.parseInt(st.nextToken());

            if (std + v > M) {
                res++;
                std = v;
            } else if (std + v == M) {
                res++;
                std = 0;
            } else {
                std += v;
            }
        }

        if (std != 0)
            res++;

        System.out.print(res);
    }
}
