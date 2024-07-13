package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_17252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        if (N == 0 || N == 2) {
            System.out.print("NO");
            return;
        }

        while (true) {
            if (N / 3 == 0)
                break;

            if (N % 3 == 2) {
                System.out.print("NO");
                return;
            }
            N /= 3;
        }

        System.out.println(N % 3 == 2 ? "NO" : "YES");
    }
}
