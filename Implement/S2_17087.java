package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_17087 {

    static int N, S;
    static int[] nums;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        nums[N] = S;
        
        if (N == 1) {
            System.out.print(Math.abs(nums[0] - S));
            return;
        }

        Arrays.sort(nums);
        for (int i = 1; i < N + 1; i++) list.add(nums[i] - nums[i - 1]);

        int std = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            std = gcd(std, list.get(i));
        }

        System.out.print(std);
    }

    static int gcd(int a, int b) {
        int r = 0;
        while (a % b != 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return b;
    }
}
