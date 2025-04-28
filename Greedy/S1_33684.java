package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_33684 {

    static int N, K;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N];
        boolean flag = true;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            nums[i] = Integer.parseInt(st.nextToken());

            if (nums[i] > K) flag = false;
        }
        
        Arrays.sort(nums);
        
        if (!flag) {
            System.out.print(0);
            return;
        } 

        if (nums[0] <= 0) {
            System.out.print(-1);
            return;
        }

        long res = 0;
        for (int i = 1; i < N; i++) {
            res += (K - nums[i]) / nums[0];
        }

        System.out.print(res + 1);
    }
}
