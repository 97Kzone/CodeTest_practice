package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_25184 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        int a = N / 2;
        int s = a;
        int e = (N % 2 == 1) ? N - 1 : N;

        for (int i = 0 ; i < a; i++) {
            sb.append(s + " " + e + " ");
            s--;
            e--;
        }

        sb.append(N % 2 == 1 ? N : "");
        System.out.print(sb.toString());
    }
}
