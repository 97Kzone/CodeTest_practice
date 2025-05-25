package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_33520 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long w = 0; 
        long h = 0;

        long a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());

            w = Math.max(w, Math.min(a, b));
            h = Math.max(h, Math.max(a, b));
        }

        System.out.print(w * h);
    }
}
