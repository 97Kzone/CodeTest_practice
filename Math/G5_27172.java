package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class G5_27172 {

    static int N, std;
    static int[] nums, cnt;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        set = new HashSet<>();
        std = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            set.add(nums[i]);
            std = Math.max(std, nums[i]);
        }

        cnt = new int[std + 1];
        for (int n : nums) {
            if (n == std) continue;

            for (int i = n * 2; i <= std; i += n) {
                if (set.contains(i)) {
                    cnt[n]++;
                    cnt[i]--;
                }
            }
        }
        for (int n : nums) sb.append(cnt[n] + " ");
        System.out.print(sb);
    }
}
