package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_27972 {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int mode = 0; 
        int prev = nums[0]; 
        int leng = 1, down = 1, up = 1; 

        for (int i = 1; i < N; i++) {
            if (nums[i] > prev) {
                if (mode == 0) {
                    leng = 2;
                } else if (mode == 1) {
                    leng++;
                } else if (mode == -1) {
                    down = Math.max(down, leng);
                    leng = 2;
                }
                mode = 1;
            } else if (nums[i] < prev) {
                if (mode == 0) {
                    leng = 2;
                } else if (mode == 1) {
                    up = Math.max(up, leng);
                    leng = 2;
                } else if (mode == -1) {
                    leng++;
                }
                mode = -1;
            }
            prev = nums[i];
        }

        if (mode == 1) {
            up = Math.max(up, leng);
        } else if (mode == -1) {
            down = Math.max(down, leng);
        }

        System.out.println(Math.max(up, down));
    }
}
