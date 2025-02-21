package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_31872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        int[] std = new int[N];
        int res;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int idx = 0;

        for (int i = 0; i < N; i++) {
            std[i] = nums[i] - idx;
            idx = nums[i];
        }

        Arrays.sort(std);

        res = 0;

        for (int i = 0; i < N - K; i++) {
            res += std[i];
        }

        System.out.print(res);
    }
}
