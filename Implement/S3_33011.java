package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_33011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N, num, tmp;
        int[] nums;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            nums = new int[2];
            for (int i = 0; i < N; i++) {
                num = Integer.parseInt(st.nextToken());
                nums[num % 2]++;
            }

            if (nums[0] > nums[1]) {
                tmp = nums[0];
                nums[0] = nums[1];
                nums[1] = tmp;
            }

            sb.append((nums[1] % 2 != 0 && nums[0] != nums[1]) ? "amsminn" : "heeda0528").append("\n");
        }
        System.out.print(sb.toString());
    }
}
