package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_32712 {

    static int N, K;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long res = 0;
        long val = 0;
        int std = Math.min(N, K);
        for (int i = 0; i < std; i++) {
            res = Math.max(res, val + ((long)(K - i) * nums[i]));
            val += nums[i];
        }

        for (int i = 0; i < N / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[N - i - 1];
            nums[N - i - 1] = tmp;
        }

        val = 0;
        for (int i = 0; i < std; i++) {
            res = Math.max(res, val + ((long)(K - i) * nums[i]));
            val += nums[i];
        }

        System.out.print(res);
    }
}