package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_20921 {

    static int N, K;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        int tmp;
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            for (int j = N - 1; j > i - 1; j--) {
                if (cnt >= K)
                    break;

                tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
                cnt++;
            }
            if (cnt >= K)
                break;
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
