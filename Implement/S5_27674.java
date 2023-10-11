package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class S5_27674 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N * 2; i++) {
            if (i % 2 == 0) {
                br.readLine();
                continue;
            }

            String[] nums = br.readLine().split("");

            Arrays.sort(nums, Collections.reverseOrder());

            long a, b;
            String s = "";
            for (int j = 0; j < nums.length - 1; j++) {
                s += nums[j];
            }

            a = Long.parseLong(s);
            b = Long.parseLong(nums[nums.length - 1]);

            System.out.println(a + b);
        }

    }
}
