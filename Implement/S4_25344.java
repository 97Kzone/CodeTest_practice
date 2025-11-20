package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_25344 {

    static int N;
    static long[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        nums = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 2; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        } 

        long res = nums[0];
        for (int i = 1; i < N - 2; i++) {
            res = res * nums[i] / gcd(res, nums[i]);
        }

        System.out.print(res);
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
