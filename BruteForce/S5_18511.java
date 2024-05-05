package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_18511 {

    static int N, K, res;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);
        res = 0;
        check(0);
        System.out.print(res);
    }
    
    static void check(int n) {
        if (n > N) return;
        if (res < n) res = n;
        
        for (int i = K - 1; i >= 0; i--) {
            check(n * 10 + nums[i]);
        }
    }
}
