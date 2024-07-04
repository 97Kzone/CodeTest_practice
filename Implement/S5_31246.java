package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_31246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            nums[i] = b - a;
        }
        Arrays.sort(nums);

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (K == 0)
                break;

            if (nums[i] > 0)
                res = nums[i];
            K--;
        }
        System.out.print(res);
    }

}
