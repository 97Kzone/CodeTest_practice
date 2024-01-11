package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_17392 {

    static int N, M;
    static int[] nums, nums2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        nums2 = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int std = 0, res = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            std += nums[i] + 1;
        }

        if (M <= 0) {
            System.out.print(0);
            return;
        }

        int flag = M - std;
        while (true) {
            for (int i = 0; i < N + 1; i++) {
                if (flag <= 0) break;

                nums2[i]++;
                flag--;
            }
            
            if (flag <= 0) break;
        }

        for (int i = 0; i < N + 1; i++) {
            for (int j = 1; j <= nums2[i]; j++) {
                res += j * j;
            }
        }
        System.out.print(res);
    }   
}
