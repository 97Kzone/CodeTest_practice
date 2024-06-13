package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_12788 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        int std = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            std += nums[i];
        }

        if (std < M * K) {
            System.out.print("STRESS");
        } else {
            Arrays.sort(nums);
            int cnt = 0;
            int res = 0;
            std = M * K;

            for (int i = N - 1; i >= 0; i--) {
                cnt += nums[i];
                res++;

                if (cnt >= std) {
                    System.out.print(res);
                    break;
                }
            }
        }
    }
}
