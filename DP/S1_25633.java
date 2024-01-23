package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_25633 {
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
        int v, cnt; // 누적 값
        for (int i = 0; i < N; i++) {
            v = nums[i];
            cnt = 0;
            for (int j = i + 1; j < N; j++) {
                if (v >= nums[j]) v += nums[j];
                else cnt++;
            }

            res = Math.max(res, N - i - cnt);
        }
        
        System.out.print(res);
    }
}
