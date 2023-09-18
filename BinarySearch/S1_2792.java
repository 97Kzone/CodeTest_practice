package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S1_2792 {

    static int N, M;
    static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int r = 0;
        nums = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            nums.add(Integer.parseInt(br.readLine()));
            r = Math.max(r, nums.get(i));
        }

        int l = 1;
        int cnt = 0, res = 0;
        int m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            cnt = 0;

            for (int num : nums) {
                if (num % m == 0) {
                    cnt += (num / m);
                } else {
                    cnt += (num / m) + 1;
                }
            }

            if (cnt > N) {
                l = m + 1;
            } else {
                res = m;
                r = m - 1;
            }

        }
        System.out.print(res);
    }
}
