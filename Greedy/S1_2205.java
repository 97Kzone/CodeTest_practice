package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_2205 {

    static int N;
    static int[] nums, visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        visit = new int[N + 1];

        for (int i = N; i > 0; i--) {
            for (int j = N; j > 0; j--) {
                if (visit[j] == 1)
                    continue;

                if (check(i, j)) {
                    visit[j] = 1;
                    nums[i] = j;
                    break;
                }
            }
        }
        for (int i = 1; i <= N; i++) sb.append(nums[i] + "\n");

        System.out.print(sb);
    }

    static boolean check(int i, int j) {
        int v = i + j;

        while (true) {
            if (v == 1) return true; 
            
            if (v % 2 != 0) return false;
        
            v /= 2;
        }
    }
}
