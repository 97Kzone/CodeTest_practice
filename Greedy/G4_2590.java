package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_2590 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[7];
        for (int i = 1; i < 7; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int res = nums[6];
        int tmp;
        while (nums[5] > 0) {
            tmp = 36 - 5 * 5;
            nums[5]--;
            nums[1] = Math.max(nums[1] - tmp, 0);
            res++;
        }
        
        while (nums[4] > 0) {
            tmp = 36 - 4 * 4;
            tmp -= (Math.min(nums[2], 5) * 4);
            nums[4]--;
            nums[2] = Math.max(nums[2] - 5, 0);
            nums[1] = Math.max(nums[1] - tmp, 0);
            res++;
        }
        
        while (nums[3] > 0) {
            tmp = 36 - 9 * Math.min(nums[3], 4);

            if (nums[3] >= 4) {
                nums[3] -= 4;
                tmp = 0;
            } else if (nums[3] == 3) {
                tmp -= Math.min(nums[2], 1) * 4;
                nums[3] -= 3;
                nums[2] = Math.max(nums[2] - 1, 0);
            } else if (nums[3] == 2) {
                tmp -= Math.min(nums[2], 3) * 4;
                nums[3] -= 2;
                nums[2] = Math.max(nums[2] - 3, 0);
            } else {
                tmp -= Math.min(nums[2], 5) * 4;
                nums[3]--;
                nums[2] = Math.max(nums[2] - 5, 0);
            }
            nums[1] = Math.max(nums[1] - tmp, 0);
            res++;
        }

        while (nums[2] > 0) {
            tmp = 36 - 4 * Math.min(nums[2], 9);
            nums[2] = Math.max(nums[2] - 9, 0);
            nums[1] = Math.max(nums[1] - tmp, 0);
            res++;
        }

        while (nums[1] > 0) {
            nums[1] = Math.max(nums[1] - 36, 0);
            res++;
        }

        System.out.print(res);
    }
}
