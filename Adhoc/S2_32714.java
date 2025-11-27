package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_32714 {

    static int[] nums = {0, 0, 1, 3};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int res = 0;
        res = N <= 3 ? nums[N] : (N * 3) - 4;
        
        System.out.print(res);
    }
}
