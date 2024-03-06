package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        double[] nums = new double[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(nums);
        double res = nums[N - 1];
        for (int i = 0; i < N - 1; i++) {
            res += nums[i] / 2;
        }

        System.out.print(res);
    }
}
