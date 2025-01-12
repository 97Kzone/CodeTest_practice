package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_14495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[117];
        
        nums[1] = 1;
        nums[2] = 1;
        nums[3] = 1;

        for (int i = 4; i <= N; i++) {
            nums[i] = nums[i - 1] + nums[i - 3];
        }

        System.out.print(nums[N]);
    }
}
