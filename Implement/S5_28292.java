package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_28292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[] { 1, 1, 2, 2, 2, 3 };
        
        if (N >= 6) {
            System.out.print(nums[5]);
        } else {
            System.out.print(nums[N-1]);
        }
    }
}
