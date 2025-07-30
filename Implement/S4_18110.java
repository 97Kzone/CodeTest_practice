package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class S4_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int std = (int) Math.round(N * 0.15);

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        double res = 0;
        for (int i = std; i < N - std; i++) {
            res += nums[i];
        }

        long v = (int) Math.round(res / (N - (std * 2)));

        bw.write(String.valueOf(v));
        bw.flush();
        bw.close();
    }
}
