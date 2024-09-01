package Implement;

import java.io.*;
import java.util.*;

public class S4_28419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long sum1 = 0; // 홀
        long sum2 = 0; // 짝

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                sum2 += Integer.parseInt(st.nextToken());
            } else {
                sum1 += Integer.parseInt(st.nextToken());
            }
        }

        long res;
        // 불가능한 경우
        if (N == 3) {
            if (Math.abs(sum1 - sum2) > 1) {
                res = -1;
            } else {
                res = Math.abs(sum1 - sum2);
            }
        } else {
            res = Math.abs(sum1 - sum2);
        }

        System.out.print(res);
    }
}
