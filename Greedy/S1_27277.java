package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_27277 {

    static int N;
    static int[] nums, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int l = 0, r = N - 1;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0)
                arr[i] = nums[r--];
            else
                arr[i] = nums[l++];
        }

        int res = arr[0];
        for (int i = 1; i < N; i++) {
            res += arr[i] - arr[i - 1] < 0 ? 0 : arr[i] - arr[i - 1];
        }

        System.out.print(res);
    }
}
