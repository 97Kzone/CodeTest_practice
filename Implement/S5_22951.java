package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_22951 {

    static int N, K, S;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = N * K;
        int[] nums = new int[S];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                nums[idx++] = Integer.parseInt(st.nextToken());
            }
        }        

        idx = 0;
        int cnt = 0;
        int std = 0; 
        while(cnt < S - 1) {
            std = nums[idx];
            nums[idx] = 0;
            cnt++;

            while(std > 0) {
                idx = (idx + 1) % S;
                if (nums[idx] == 0) continue;
                std--;
            }
        }

        idx = 0;
        for (int i = 0; i < S; i++) {
            if (nums[i] == 0) continue;

            idx = i;
            break;
        }

        int res = (idx / K) + 1;
        System.out.print(res + " " + nums[idx]);
    }
}
