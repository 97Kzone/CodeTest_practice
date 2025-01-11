package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class S4_22993 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Long> nums = new ArrayList<>();
        long std = Long.parseLong(st.nextToken());
        for (int i = 1; i < N; i++) {
            nums.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(nums);

        String res = "Yes";
        for (long num : nums) {
            if (std > num) {
                std += num;
            } else if (std == num) {
                continue;
            } else {
                res = "No";
                break;
            }
        }

        System.out.print(res);
    }
}
