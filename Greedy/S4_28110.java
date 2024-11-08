package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_28110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums);
        int cnt = 0;
        int res = -1;

        int tmp;
        for (int i = 1; i < N; i++) {
            tmp = (nums[i] - nums[i - 1]) / 2;
            if (tmp > cnt) {
                res = nums[i - 1] + tmp;
                cnt = tmp;
            }
        }
        System.out.print(res);

    }
}
