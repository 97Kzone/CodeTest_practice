package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_11332 {

    static String cmd;
    static int N, T, L;
    static int std = 100_000_000;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int C = Integer.parseInt(br.readLine());

        for (int c = 0; c < C; c++) {
            st = new StringTokenizer(br.readLine());

            cmd = st.nextToken();
            N = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            check();
        }

        System.out.print(sb.toString());
    }

    static void check() {
        double v = (L * std) / T;        

        boolean flag = true;
        long tmp;
        if ("O(N)".equals(cmd)) {
            flag = v >= N ? true : false;
        } else if ("O(N^2)".equals(cmd)) {
            flag = (v / N) >= N ? true : false;
        } else if ("O(N^3)".equals(cmd)) {
            flag = ((v / N) / N) >= N ? true : false;
        } else if ("O(2^N)".equals(cmd)) {
            tmp = 1;
            for (int i = 0; i < N; i++) {
                tmp <<= 1;
                if (tmp > v) flag = false;
            }
        } else if ("O(N!)".equals(cmd)) {
            tmp = 1;
            for (int i = 2; i <= N; i++) {
                tmp *= i;
                if (tmp > v) flag = false;
            }
        } 

        sb.append(flag ? "May Pass." : "TLE!").append("\n");
    }
}
