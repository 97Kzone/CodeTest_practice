package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_15966 {
    
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        nums = new int[1000001];

        st = new StringTokenizer(br.readLine());
        int n, res;
        res = 0;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(st.nextToken());

            nums[n] = Math.max(nums[n], nums[n - 1] + 1);
            if (nums[n] > res) res = nums[n];
        }
        
        System.out.print(res);
    }
}
