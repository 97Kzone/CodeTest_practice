package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S1_24954 {

    static int N, res;
    static boolean[] used;
    static int[] nums;
    static List<sale>[] sales;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        nums = new int[N+1];
        sales = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sales[i] = new ArrayList<>();
        }

        int a, b, c;
        for (int i = 1; i <= N; i++) {
            a = Integer.parseInt(br.readLine());

            for (int j = 0; j < a; j++) {
                st = new StringTokenizer(br.readLine());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                sales[i].add(new sale(b, c));
            }
        }

        used = new boolean[N+1];
        res = Integer.MAX_VALUE;
        check(1, 0);

        System.out.print(res);
    }

    static void check(int idx, int cnt) {
        if (idx == N + 1) {
            res = Math.min(res, cnt);
            return;
        }

        if (cnt >= res) return;

        int tmp;
        for (int i = 1; i <= N; i++) {
            if (used[i]) continue;

            used[i] = true;
            for (sale s : sales[i]) nums[s.idx] -= s.val;

            tmp = nums[i] <= 0 ? 1 : nums[i];
            check(idx + 1, cnt + tmp);

            for (sale s : sales[i]) nums[s.idx] += s.val;
            used[i] = false;
        }
    }

    static class sale {
        int idx;
        int val;

        sale(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
