package Implement;

import java.io.*;
import java.util.*;


public class S4_12981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[3];

        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int res = nums[0];
        nums[1] -= nums[0];
        nums[2] -= nums[0];

        res += (nums[1] / 3) + (nums[2] / 3);
        res += (nums[1] % 3) != 0 ? 1 : 0;
        res += (nums[2] % 3) != 0 ? 1 : 0;

        if (nums[1] % 3 == 1 && nums[2] % 3 == 1) {
            res--;
        }

        System.out.print(res);
    }
}
