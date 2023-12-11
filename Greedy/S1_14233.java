package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_14233 {

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
        
        Arrays.sort(nums);
        int res = nums[0];
        int tmp;
        for (int i = 1; i < N; i++) {
            tmp = 0;
            if (res * (i + 1) > nums[i]) {
                tmp = nums[i] / (i + 1);
                res = tmp;
            }   
        }
        
        System.out.println(res);

    }
}
