package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_7571 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] numx = new int[m];
        int[] numy = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            numx[i] = Integer.parseInt(st.nextToken());
            numy[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numx);
        Arrays.sort(numy);

        int std1 = numx[m / 2];
        int std2 = numy[m / 2];

        int res = 0;
        for (int i = 0; i < m; i++) {
            res += Math.abs(std1 - numx[i]) + Math.abs(std2 - numy[i]);
        }

        System.out.print(res);
    }
}
