package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_30021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 2) {
            System.out.print("NO");
            return;
        }

        System.out.println("YES");
        System.out.print("1 ");
        if (N >= 3) {
            System.out.print("3 2 ");
        }

        for (int i = 4; i <= N; i++) {
            System.out.print(i + " ");
        }
    }
}
