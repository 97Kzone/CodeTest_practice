package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_5426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2;

        int T = Integer.parseInt(br.readLine());
        String res;
        int n;
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            n = (int) Math.sqrt(s.length());

            sb2 = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                for (int i = 0; i < n; i++) {
                    sb2.append(s.charAt(i * n + j));
;                }
            }

            sb1.append(sb2.toString() + "\n");
        }
        
        System.out.print(sb1);
    }
}
