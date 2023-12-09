import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lv3_징검다리 {
    static int N;
    static int[] nums, dp;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        dp = new int[N+1];
      
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 1;
        int std;
        dp[idx] = nums[1];
        for (int i = 2; i <= N; i++) {
            if(dp[idx] < nums[i]) {
                dp[++idx] = nums[i];
            } else {
                std = check(0, idx, nums[i]);
                dp[std] = nums[i];
            }
        }
        System.out.println(idx);
    }

    static int check(int start, int end, int n) {
        int mid = 0;
        while(start < end) {
            mid = (start + end) / 2;

            if (n <= dp[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
