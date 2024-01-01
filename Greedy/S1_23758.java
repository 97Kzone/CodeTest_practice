package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_23758 {

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
        Arrays.sort(nums);

        int res = 0;
        int idx = N % 2 != 0 ? (N / 2) + 1 : N / 2;
        int v;
        for (int i = 0; i < idx; i++) {
            v = nums[i];
            while (v > 1) {
                v /= 2;
                res++;
            }
        }

        System.out.print(res + 1);
    }   
}
