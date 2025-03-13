package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] nums = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            nums[i] += nums[i-1];
        }
        
        long res = nums[M-1];

        for (int i = M; i <= N; i++) {
            res = Math.max(res, nums[i] - nums[i - M]);
        }

        System.out.print(res);


    }
}
