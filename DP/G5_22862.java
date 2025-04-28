package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_22862 {

    static int N, K;
    static int[] nums, std;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N+1];
        std = new int[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            
            if (nums[i] % 2 == 1) std[i] = std[i-1] + 1;
            else std[i] = std[i-1]; 
        }

        int l = 1;
        int res = 0;

        for (int r = 1; r <= N; r++) {
            while (l <= r && (std[r] - std[l-1]) > K) {
                l++;
            }
            res = Math.max(res, (r-l+1) - (std[r] - std[l-1]));
        }
        System.out.print(res);
    }
}
