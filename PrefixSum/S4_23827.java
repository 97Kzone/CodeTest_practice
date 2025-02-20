package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_23827 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        long[] std = new long[N+1];
        for (int i = 1; i <= N; i++) {
            std[i] = std[i-1] + nums[i];
        }

        long res = 0;
        for (int i = 1; i< N; i++) {
            res += nums[i] * (std[N] - std[i]);
            res %= 1_000_000_007; 
        }

        System.out.print(res);
    
    }
}
