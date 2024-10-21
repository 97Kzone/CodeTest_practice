package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_11582 {

    static int N, K;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i += (N / K)) {
            check(i, i + (N / K));
        }
        
        for (int i = 0; i < N; i++) {
            sb.append(nums[i] + " ");
        }

        System.out.print(sb);
    }
    
    static void check(int l, int r) {
        int[] tmp = new int[r - l];

        for (int i = l; i < r; i++) {
            tmp[i - l] = nums[i];
        }
        Arrays.sort(tmp);

        for (int i = l; i < r; i++) {
            nums[i] = tmp[i - l];
        }
    }
}
