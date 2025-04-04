package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_10974 {

    static int N;
    static int[] nums;
    static boolean[] used;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        used = new boolean[N+1];

        check(0);

        System.out.print(sb.toString());
    }

    static void check(int d) {
        if (d == N) {
            for (int i = 0; i < N; i++) {
                sb.append(nums[i] + " ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i]) continue;

            used[i] = true;
            nums[d] = i;
            check(d+1);
            used[i] = false;
        }
    }
}
