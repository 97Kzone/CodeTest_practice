package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_15312 {

    static int[] std = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        
        int[] num = new int[A.length() + B.length()];
        int l = num.length;
        for (int i = 0; i < l - 1; i = i + 2) {
            num[i] = std[A.charAt(i / 2) - 65];
            num[i + 1] = std[B.charAt(i / 2) - 65];
        }

        while (l > 2) {
            for (int i = 0; i < l - 1; i++) {
                num[i] = (num[i] + num[i + 1]) % 10;
            }
            l--;
            num[l] = 0;
        }
        System.out.print(String.valueOf(num[0]) + String.valueOf(num[1]));
    }
}
