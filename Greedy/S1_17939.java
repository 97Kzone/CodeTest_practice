package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_17939 {
    
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
        
        int res = 0;
        int M = nums[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            if (nums[i] > M) {
                M = nums[i];
            } else {
                res += M - nums[i];
            }
        }
        System.out.print(res);
    }
}
