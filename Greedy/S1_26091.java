package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_26091 {

    static int N, M;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int cnt = 0; // 총 몇 쌍이 가능할까
        int l = 0, r = N - 1;
        int v;
        while (l < r) {
            v = nums[l] + nums[r];

            if (v >= M) {
                cnt++;
                l++;
                r--;
            } else {
                l++;
            }
        }

        System.out.print(cnt);
    }
}
