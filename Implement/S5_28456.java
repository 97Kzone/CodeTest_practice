package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_28456 {

    static int N, Q;
    static int[][] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Q = Integer.parseInt(br.readLine());

        int a, b, tmp;
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                b = Integer.parseInt(st.nextToken()) - 1;
                tmp = nums[b][N-1];
                for (int i = N - 1; i > 0; i--) {
                    nums[b][i] = nums[b][i-1];
                }
                nums[b][0] = tmp;
            } else {
                rotate();
            }
        }

        for (int[] num : nums) {
            for (int n : num) {
                bw.write(n + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void rotate() {
        int[][] tmp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[j][N-i-1] = nums[i][j];
            }
        }

        nums = tmp;
    }
}
