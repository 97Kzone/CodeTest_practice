package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class G4_17255 {

    static String target;
    static char[] nums;
    static Set<String> set = new HashSet<>();
    static int res, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        nums = target.toCharArray();
        N = target.length();

        res = 0;
        for (int i = 0; i < N; i++) {
            check(i, i, nums[i] + "", nums[i] + "");
        }

        System.out.print(res);
    }
    
    static void check(int l, int r, String std, String now) {
        if (target.equals(std) && !set.contains(now)) {
            set.add(now);
            res++;
        } else {
            if (l > 0) check(l - 1, r, nums[l - 1] + std, now + std);
            if (r < N - 1) check(l, r + 1, std + nums[r + 1], now + std);
        }
    }
}
