package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_28065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int l = 1;
        int r = N;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                sb.append(l + " ");
                l++;
            } else {
                sb.append(r + " ");
                r--;
            }
        }

        System.out.print(sb);
    }
}
