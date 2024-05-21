package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_16162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int res = 0;
        int std, cnt;
        for (int i = 0; i < N; i++) {
            if (nums[i] != A)
                continue;

            std = nums[i];
            cnt = 1;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] == std + D) {
                    std = nums[j];
                    cnt++;
                }
            }

            res = Math.max(res, cnt);
        }

        System.out.print(res);
    }
}
