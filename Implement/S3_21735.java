package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_21735 {

    static int N, M, res;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N+1];
        nums[0] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        check(1, 0, 0);
        System.out.print(res);
    }

    static void check(int size, int t, int idx) {
        if (t > M) return;

        if (t <= M) res = Math.max(res, size);

        if (idx <= N - 1) check(size + nums[idx + 1], t + 1, idx + 1);

        if (idx <= N - 2) check((size / 2) + nums[idx + 2], t + 1, idx + 2);
    }
}
