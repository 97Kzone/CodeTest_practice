package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_17213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        long v1 = 1;
        long v2 = 1;

        for (int i = M-N+1; i <= M-1; i++) v1 *= i;
        for (int i = 1; i <= N - 1; i++) v2 *= i;

        System.out.print(v1 / v2);
    }
}
