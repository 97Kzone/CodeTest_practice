package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_23365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);
        long res = 0;
        res += Math.max(nums[0], nums[N-1]);
        for (int i = 1; i < N; i++) {
            res += Math.max(nums[i], nums[i-1]);
        }

    
        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}
