package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_10709 {
    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        res = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(res[i], -1);
        }

        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'c')
                    res[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (res[i][j] == 0)
                    continue;

                if (res[i][j - 1] != -1) {
                    res[i][j] = res[i][j - 1] + 1;
                }
            }
        }

        for (int[] a : res) {
            for (int i = 0; i < M; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
