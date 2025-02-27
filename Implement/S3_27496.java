package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_27496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        int[] std = new int[N+1];

        for (int i = 1; i <= N; i++) {
            std[i] = std[i-1] + nums[i-1];
            if (i > L) std[i] -= nums[i-L-1];
            if (std[i] >= 129 && std[i] <= 138) res++;
        }

        System.out.print(res);
    }
}
