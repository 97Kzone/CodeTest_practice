package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[M];

        int std = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            std += nums[i];
        }

        int tmp = Integer.parseInt(br.readLine());
        double res = 0;
        double v = 0;
        for (int i = 0; i < M; i++) {
            v = 1;
            for (int j = 0; j < tmp; j++) {
                v *= ((double) (nums[i] - j) / (std - j));
            }
            res += v;
        }

        System.out.print(res);
        
    }
}
