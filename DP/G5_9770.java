package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_9770 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        if (N % 7 == 0 || N % 7 == 2) System.out.print("CY");
        else System.out.print("SK");
    }
}
