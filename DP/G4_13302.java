package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_13302 {

    static int N, M, res;
    static int[] nums;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[101][101];
        nums = new int[102];

        st = new StringTokenizer(br.readLine());
        int idx;
        for (int i = 0; i < M; i++) {
            idx = Integer.parseInt(st.nextToken());
            nums[idx] = 1;
        }

        res = Integer.MAX_VALUE;
        check(1, 0, 0);

        System.out.print(res);
    }

    static void check(int d, int v, int c) {
        if (d > N) {
            res = Math.min(res, v);
            return;
        }

        if (dp[d][c] == 0) dp[d][c] = v;
        else if (dp[d][c] > v) dp[d][c] = v;
        else return;
        
        if (nums[d] != 0) {
            while (nums[d] != 0)
                d++;
            check(d, v, c);
            return;
        }

        if (c >= 3)
            check(d + 1, v, c - 3);
        
        check(d + 1, v + 10000, c);
        check(d + 3, v + 25000, c + 1);
        check(d + 5, v + 37000, c + 2);
    }
}
