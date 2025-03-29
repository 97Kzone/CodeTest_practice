package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_15664 {

    static int N, M;
    static int[] nums, res;
    static boolean[] visit;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N+1];
        res = new int[M];
        visit = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        check(1, 0);
        
        System.out.print(sb.toString());
    }

    static void check(int now, int d) {
        if(d == M) {
            for (int n : res) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        int tmp = 0;
        for (int i = now; i <= N; i++) {
            if(!visit[i]) {
                if (tmp == nums[i]) continue;
            }

            visit[i] = true;
            res[d] = nums[i];
            check(i + 1, d + 1);
            visit[i] = false;
            tmp = nums[i];
        }
    }
}
