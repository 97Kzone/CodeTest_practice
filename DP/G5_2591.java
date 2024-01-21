package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_2591 {

    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        N = s.length();
        nums = new int[N + 1];

        nums[0] = 1;
        nums[1] = 1;
        for (int i = 1; i < N; i++) {
            nums[i + 1] += nums[i];

            if (s.charAt(i - 1) != '0') {
                int tmp = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
                if (1 <= tmp && tmp <= 34) {
                    nums[i + 1] += nums[i - 1];
                }
            }
                  
            if (s.charAt(i) == '0') {
                nums[i + 1] -= nums[i];
            }
        }
        
        System.out.print(nums[N]);
    }
}
