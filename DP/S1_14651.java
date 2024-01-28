package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_14651 {

    static int N;   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.print(0);
            return;
        }

        long res = 2;
        for (int i = 2; i < N; i++) {
            res = (res * 3) % 1000000009;
        }

        System.out.print(res);
    }
}
