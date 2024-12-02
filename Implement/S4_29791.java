package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_29791 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num1 = new int[N];
        int[] num2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            num2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num1);
        Arrays.sort(num2);

        int res1 = 1;
        int res2 = 1;

        int std = num1[0];
        for (int i = 1; i < N; i++) {
            if (num1[i] - std >= 100) {
                res1++;
                std = num1[i];
            }
        }

        std = num2[0];
        for (int i = 1; i < M; i++) {
            if (num2[i] - std >= 360) {
                res2++;
                std = num2[i];
            }
        }

        System.out.print(res1 + " " + res2);
    }
}
