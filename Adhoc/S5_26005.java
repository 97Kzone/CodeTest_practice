package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_26005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int std = N * N;
        if (N == 1) {
            System.out.print(0);
            return;
        }
        System.out.print(N % 2 == 1 ? (std / 2) + 1 : std / 2);
    }
}
