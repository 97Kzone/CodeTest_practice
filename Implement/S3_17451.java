package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_17451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        long std = nums[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            if (std < nums[i]) {
                std = nums[i];
            } else if (nums[i] < std && std % nums[i] != 0) {
                std = ((std / nums[i] + 1)) * nums[i];
            }
        }

        System.out.print(std);
    }
}
