package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_14400 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] num1 = new int[N];
        int[] num2 = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            num1[i] = Integer.parseInt(st.nextToken());
            num2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num1);
        Arrays.sort(num2);

        int std1 = num1[N / 2];
        int std2 = num2[N / 2];

        long res = 0;
        for (int i = 0; i < N; i++) {
            res += Math.abs(std1 - num1[i]) + Math.abs(std2 - num2[i]);
        }

        System.out.println(res);
    }
}
