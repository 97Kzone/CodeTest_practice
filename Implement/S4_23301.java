package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_23301 {

    static int N, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[] nums = new int[1002];

        int K;
        int s = 0, e = 0; 
        for (int i = 0; i < N; i++) {
            K = Integer.parseInt(br.readLine());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                nums[s] += 1;
                nums[e] -= 1;
            }
        }

        for (int i = 1; i < 1002; i++) {
            nums[i] += nums[i-1]; 
        }

        int res = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < 1002 - T; i++) {
            sum = 0;
            for (int j = i; j < T + i; j++) {
                sum += nums[j];
            }

            if (res < sum) {
                res = sum;
                s = i;
                e = i + T;
            }
        }

        System.out.println(s + " " + e);
    }
}
