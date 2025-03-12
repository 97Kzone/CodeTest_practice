package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_32194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N+2];
        nums[1] = 1; // 첫 질문은 YES

        int cmd, s, e;
        boolean flag;
        for (int i = 2; i < N + 2; i++) {
            st = new StringTokenizer(br.readLine());

            cmd = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            flag = false;
            if (cmd == 1) {
                if (nums[e] - nums[s] == e - s && nums[s] - 1 == nums[s-1]) {
                    nums[i] = nums[i-1] + 1;
                    flag = true;
                } else nums[i] = nums[i-1];
            } else {
                if (nums[s] == nums[e] && nums[s] == nums[s-1]) {
                    nums[i] = nums[i-1] + 1;
                    flag = true;
                } else nums[i] = nums[i-1];
            }

            sb.append(flag ? "Yes" : "No").append("\n");
        }

        System.out.print(sb.toString());
    }
}
