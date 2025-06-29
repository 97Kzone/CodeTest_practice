package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_16391 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long res = 0;
        char c;
        for (int i = 0; i < N; i++) {
            c = br.readLine().charAt(0);
            if (c == 'O') res = res * 2 + 1;
            else res = res * 2;
        }

        System.out.print(res);
    }
}
