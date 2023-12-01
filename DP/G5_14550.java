package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_14550 {

    static int N, S, T;
    static int[] dp, nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
  
        int v;
        String[] tmp;
        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            S = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            nums = new int[N+2];
            int idx = 1;
            while(idx != N+1) {
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens())  nums[idx++] = Integer.parseInt(st.nextToken());
            }
            sb.append(check(T) + "\n");
        }
        System.out.print(sb.toString());
    }

    static int check(int t) {
        dp = new int[N+2];
        Arrays.fill(dp, -10000000);
        dp[0] = 0;

        int res = -10000000;
        int[] std;
        while (true) {
            if (t == 0) break;
            
            std = new int[N+2];
            Arrays.fill(std, -10000000);

            for (int i = 1; i <= N+1; i++) {
                for (int j = 1; j <= S; j++) {
                    if(i - j < 0 || dp[i - j] == -10000000) continue;

                    std[i] = Math.max(std[i], dp[i - j] + nums[i]);
                }
            }

            res = Math.max(res, std[N+1]);
            dp = std;
            t--;
        }

        return res;
    }
}
