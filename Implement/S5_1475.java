package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] nums = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';

            if (num == 6) {
                nums[9]++;
            } else {
                nums[num]++;
            }
        }

        int max = 0;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, nums[i]);
        }

        int std = nums[9] / 2;
        if (nums[9] % 2 == 1)
            std++;

        max = Math.max(max, std);
        System.out.print(max);
    }
}
