package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_11054 {
    static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int[] up = new int[N];
        int[] down = new int[N];

        int idx = 0;
        for (String s : br.readLine().split(" ")) {
            nums[idx] = Integer.parseInt(s);
            up[idx] = 1;
            down[idx++] = 1;
        }

        //오름차
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], up[j]+1);
                }
            }
        }
        //내림차
        for (int i = N-2; i >= 0; i--) {
            for (int j = N-1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    down[i] = Math.max(down[i], down[j]+1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, up[i] + down[i] - 1);
        }
        br.close();
        System.out.println(res);
    }
    public static void main(String[] args) throws IOException {
        sol();
    }
}
