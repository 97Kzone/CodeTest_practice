package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        long std;
        for (int i = 0; i < N; i++) {
            std = Long.parseLong(st.nextToken());

            long v = (long) Math.sqrt(std);

            if (v * v == std) sb.append(1 + " ");
            else sb.append(0 + " ");
        }
        System.out.print(sb);
    }
}
