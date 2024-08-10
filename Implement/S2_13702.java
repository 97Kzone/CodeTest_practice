package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_13702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] nums = new long[N];
        long l = 1, r = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
            r = Math.max(r, nums[i]);
        }

        long m;
        long res = 0;
        int cnt;
        while (l <= r) {
            m = (l + r) / 2;
            cnt = 0;

            for (long num : nums) {
                cnt += num / m;
            }

            if (cnt >= K) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        System.out.print(res);

    }
}
