package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_14753 {

    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int res = check();
        System.out.print(res);
    }

    static int check() {
        Arrays.sort(nums);

        int max1 = nums[N - 1] * nums[N - 2] * nums[N - 3];
        int max2 = nums[N - 1] * nums[0] * nums[1];
        int max3 = nums[N-1] * nums[N -2];
        int max4 = nums[0] * nums[1];

        return Math.max(Math.max(max1, max2), Math.max(max3, max4));
    }
}
