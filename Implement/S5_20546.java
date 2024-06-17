package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] nums = new int[14];
        int stk1 = 0, stk2 = 0;
        int cash1 = N, cash2 = N;

        // JH
        for (int i = 0; i < 14; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (cash1 >= nums[i]) {
                stk1 += cash1 / nums[i];
                cash1 %= nums[i];
            }
        }

        // SM
        int up = 0, down = 0;
        for (int i = 1; i < 14; i++) {
            if (nums[i] > nums[i - 1]) {
                down = 0;
                up++;
            } else if (nums[i] < nums[i - 1]) {
                down++;
                up = 0;
            }

            if (up == 3) {
                cash2 += stk2 * nums[i];
                stk2 = 0;
            } else if (down == 3) {
                stk2 += cash2 / nums[i];
                cash2 %= nums[i];
            }
        }
        
        int res1 = stk1 * nums[13] + cash1;
        int res2 = stk2 * nums[13] + cash2;

        if (res1 > res2) {
            System.out.print("BNP");
        } else if (res1 < res2) {
            System.out.print("TIMING");
        } else {
            System.out.print("SAMESAME");
        }
    }
}
