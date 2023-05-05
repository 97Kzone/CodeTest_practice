package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G2_22963 {

    static final int INF = 998244353;
    static int N;
    static List<Integer> lis, v;
    static Pair[] nums;

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        lis = new ArrayList<>();
        v = new ArrayList<>();
        nums = new Pair[200001];

        int[] ans = new int[234567];
        ans[0] = -1;

        lis.add(-INF);

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            v.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < N; i++) {
            if (lis.get(lis.size() - 1) <= v.get(i)) {
                lis.add(v.get(i));
                nums[i] = new Pair(v.get(i), lis.size() - 1);
            } else {
                int idx = upperBound(lis, v.get(i));
                lis.set(idx, v.get(i));
                nums[i] = new Pair(v.get(i), idx);
            }
        }

        int ptr = lis.size() - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (nums[i].second == ptr) {
                ans[ptr] = nums[i].first;
                ptr--;
            }
        }

        if (N - lis.size() + 1 <= 3) System.out.println("YES");
        else {
            System.out.println("NO");
            return;
        }

        v.add(1000000000);
        System.out.println(N - lis.size() + 1);

        ptr = lis.size() - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (!v.get(i).equals(ans[ptr])) {
                System.out.println((i + 1) + " " + v.get(i + 1));
                v.set(i, v.get(i + 1));
            } else ptr--;
        }
    }

    static int upperBound(List<Integer> list, int value) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;
            if (value < list.get(mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }

}
