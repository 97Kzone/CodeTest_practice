package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_9658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N % 12 == 0 || N % 12 == 2 || N % 12 == 7 || N % 12 == 9) {
            System.out.print("CY");
        } else {
            System.out.print("SK");
        }
    }
}
