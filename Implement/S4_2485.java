package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_2485 {

    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int std = 0;
        int v;
        for (int i = 0; i < N - 1; i++) {
            v = nums[i+1] - nums[i];
            std = check(v, std);
        }

        int res = (nums[N-1] - nums[0]) / std + 1 - N;
        System.out.print(res);
    }

    static int check(int a, int b) {
        int tmp;
        while(b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }
}
