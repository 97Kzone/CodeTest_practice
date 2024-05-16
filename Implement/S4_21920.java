package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_21920 {

    static int N, X;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        X = Integer.parseInt(br.readLine());

        long res = 0;
        int cnt = 0;
        for (int num : nums) {
            if (check(num, X) == 1) {
                cnt++;
                res += num;
            }
        }

        System.out.print((double)res / cnt);
        
    }
    
    static int check(int a, int b) {
        int tmp;
        while (b > 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
