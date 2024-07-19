package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_22970 {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int res = 0;
        int a, b;
        for (int i = 0; i < N; i++) {
            a = i;
            while (a + 1 < N && nums[a] < nums[a + 1]) a++;
            b = a;
            while (b + 1 < N && nums[b] > nums[b + 1]) b++;
            res = Math.max(res, b - i + 1);
            i = a;
        }
        
        System.out.print(res);
    }
}
