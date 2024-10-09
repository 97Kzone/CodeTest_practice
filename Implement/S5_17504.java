package Implement;

import java.util.*;
import java.io.*;

public class S5_17504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long v1 = 1;
        long v2 = 1;

        v1 = nums[N - 1];
        long tmp;
        for (int i = N - 2; i >= 0; i--) {
            tmp = 0;

            v2 = v1 * nums[i] + v2;
            tmp = v2;
            v2 = v1;
            v1 = tmp;
        }
        v2 = v1 - v2;

        System.out.print(v2 + " " + v1);
    }
}
