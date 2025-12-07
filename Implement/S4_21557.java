package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_21557 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int i = N - 2;
        while (i > 0) {
            if (i == 1) {
                nums[0]--;
                nums[N-1]--;
            } else {
                if (nums[0] > nums[N - 1]) nums[0]--;
                else nums[N-1]--;
            }

            i--;
        }

        System.out.println(nums[0] >= nums[N-1] ? nums[0] : nums[N-1]);
    }
}
