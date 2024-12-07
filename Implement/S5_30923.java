package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_30923 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        long res = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            res += nums[i] * 2;
        }

        res += (N * 2) + nums[0] + nums[N - 1];
        for (int i = 0; i < N - 1; i++) {
            res += Math.abs(nums[i] - nums[i + 1]);
        }
        
        System.out.print(res);
    }
}
