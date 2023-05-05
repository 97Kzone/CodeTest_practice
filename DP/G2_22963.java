package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class G2_22963 {
    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        nums[0] = Integer.parseInt(st.nextToken());

        int std;
        List<int[]> res = new ArrayList<>();
        boolean flag = false;
        for (int i = 1; i < N; i++) {
            std = Integer.parseInt(st.nextToken());

            if (nums[i - 1] > std) {
                res.add(new int[] { i + 1, nums[i - 1] });
                nums[i] = nums[i - 1];
            } else
                nums[i] = std;

            if (i == N-1)
                flag = true;

            if (res.size() == 3)
                break;
        }
        
        if (flag) {
            System.out.println("YES");
            for (int[] n : res) {
                System.out.println(n[0] + " " + n[1]);
            }
        } else {
            System.out.println("NO");
        }
    }
}
