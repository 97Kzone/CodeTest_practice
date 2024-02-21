package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_30825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        long[] std = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        std[0] = nums[0];
        
        for (int i = 1; i < N; i++) std[i] = Math.max(nums[i], std[i - 1] + K);
        for (int i = N - 2; i >= 0; i--) std[i] = std[i + 1] - K;
        
        long res = 0;
        for (int i = 0; i < N; i++) res += std[i] - nums[i];

        System.out.print(res);
    }
}
