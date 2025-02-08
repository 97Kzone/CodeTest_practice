package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_32713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] nums = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        long res = 1;
        int idx = 0;

        int cnt;
        int tmp1, tmp2;
        long std;
        while (idx < N) {
            cnt = 0;
            std = nums[idx];

            tmp1 = 1;
            tmp2 = idx + 1;

            while(tmp2 < N && cnt <= K) {
                if (nums[tmp2] != std) cnt++;
                else tmp1++;

                if (cnt > K) break;
                tmp2++;
            }
            res = Math.max(res, tmp1);
            idx++;
        }

        System.out.print(res);
    }
}
