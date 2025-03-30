package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_2992 {

    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        N = s.length();
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = s.charAt(i) - '0';
        }

        if (N == 1) {
            System.out.print(0);
            return;
        } else {
            if(check()) {
                for (int num : nums) {
                    sb.append(num);
                }
            } else {
                sb.append(0);
            }
        }

        System.out.print(sb.toString());
    }

    static boolean check() {
        int idx = -1;
        for (int i = N-2; i >= 0; i--) {
            if (nums[i] >= nums[i+1]) continue;

            idx = i;
            break; 
        }

        if (idx == -1) {
            return false;
        }

        int idx2 = -1;
        for (int i = N - 1; i >= 0; i--) {
            if(nums[i] <= nums[idx]) continue;
            
            idx2 = i;
            break;
        }

        swap(idx, idx2);
        reverse(idx+1, N-1);

        return true;
    }

    private static void swap(int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private static void reverse(int left, int right) {
        while (left < right) {
            swap(left++, right--);
        }
    }
}
 