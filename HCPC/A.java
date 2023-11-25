package HCPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int N;
        int div, mod;
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            div = N / 5;
            mod = N % 5;

            for (int j = 0; j < div; j++) {
                sb.append("++++ ");
            }

            for (int j = 0; j < mod; j++) {
                sb.append("|");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
