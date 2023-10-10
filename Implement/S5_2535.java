package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_2535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
            nums[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums, (o1, o2) -> (o2[2] - o1[2]));

        int std = 2;
        if (nums[0][0] == nums[1][0]) {
            for (int i = 2; i < N; i++) {
                if (nums[0][0] != nums[i][0]) {
                    std = i;
                    break;
                }
            }
        }

        System.out.println(nums[0][0] + " " + nums[0][1]);
        System.out.println(nums[1][0] + " " + nums[1][1]);
        System.out.println(nums[std][0] + " " + nums[std][1]);
    }
}
