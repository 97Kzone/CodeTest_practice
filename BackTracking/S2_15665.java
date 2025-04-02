package BackTracking;

import java.io.*;
import java.util.*;

public class S2_15665 {

    static int N , M, L;
    static int[] nums;
    static Set<Integer> set;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());        
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        L = set.size();
        nums = new int[L];
        int idx = 0;
        for (int n : set) {
            nums[idx++] = n;
        }

        Arrays.sort(nums);

        check("", 0);

        System.out.print(sb.toString());
    }

    static void check(String num, int cnt) {
        if (cnt == M) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 0; i < L; i++) {
            check(num + nums[i] + " ", cnt + 1);
        }
    }
}
