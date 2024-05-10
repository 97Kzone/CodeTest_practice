package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_15719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long std = 0;
        long sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            std += i;
            sum += Long.parseLong(st.nextToken());
        }
        sum += Long.parseLong(st.nextToken());
        System.out.print(Math.abs(std - sum));
    }
}
