package Greedy;

import java.io.*;
import java.util.*;

public class S4_28324 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.print(1);
            return;
        }

        long res = 1;
        int std = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (nums[i] > std) {
                std++;
            } else if (nums[i] < std) {
                std = nums[i];
            }
            res += std;
        }
        System.out.print(res);
    }
}
