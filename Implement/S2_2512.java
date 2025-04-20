package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_2512 {

    static int N, std;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            cnt += nums[i];
        }

        Arrays.sort(nums);
        std = Integer.parseInt(br.readLine());

        if (cnt <= std) {
            System.out.println(nums[N-1]);
            return;
        }

        int l = 0, r = nums[N-1];
        int m, tmp;
        int res = 0;
        while(l <= r) {
            m = (l + r) / 2;
            
            tmp = 0;
            for (int i = 0; i < N; i++) {
                tmp += Math.min(nums[i], m);
            }

            if (tmp <= std) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        System.out.print(res);
    }
}
