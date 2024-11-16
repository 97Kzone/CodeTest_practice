package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S5_32622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int tmp = nums[0];

        for (int num : nums) {
            if (tmp != num) {
                list.add(cnt);
                tmp = num;
                cnt = 1;
            } else {
                cnt++;
            }
        }

        list.add(cnt);

        int res = 0;
        for (int num : list) {
            res = Math.max(num, res);
        }

        for (int i = 0; i < list.size() - 1; i++) {
            res = Math.max(res, list.get(i) + list.get(i + 1));
        }

        System.out.print(res);
    }
}
