package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_11637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int N;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            int total = 0;
            int res = 0, cnt = 0, idx = 0;
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(br.readLine());
                total += nums[i];

                if (res < nums[i]) {
                    res = nums[i];
                    idx = i;
                    cnt = 0;
                } else if (res == nums[i]) {
                    cnt++;
                }
            }

            if (cnt != 0) {
                sb.append("no winner" + "\n");
            } else {

                if ((double) res / (double) total > 0.5) {
                    sb.append("majority winner " + (idx + 1) + "\n");
                } else {
                    sb.append("minority winner " + (idx + 1) + "\n");
                }
            }
        }
        System.out.print(sb);
    }
}
