package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_33573 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long n1, n2;
        StringBuilder s;
        for (int t = 0; t < T; t++) {
            s = new StringBuilder(br.readLine());
            n1 = Long.parseLong(s.toString());
            n2 = Long.parseLong(s.reverse().toString());

            sb.append(Math.sqrt(n1) % 1 == 0 && Math.sqrt(n2) % 1 == 0 ? "YES" : "NO").append("\n");
        }

        System.out.print(sb.toString());
    }
}
