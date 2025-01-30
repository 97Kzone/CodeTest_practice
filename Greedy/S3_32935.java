package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_32935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        long sum = 0;
        int min = Integer.MAX_VALUE;
        int idx = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (min > nums[i]) {
                min = nums[i];
                idx = i;
            }
            sum += nums[i];
        }

        if (sum < sum - nums[idx] + (-sum)){
            sum = sum - nums[idx] + (-sum);
        }

        System.out.print(sum);
    }
}
