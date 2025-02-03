package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_12927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int N = s.length();
        int[] nums = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = s.charAt(i-1) == 'Y' ? 1 : 0;
        }

        int res = 0;
        int idx;
        for (int i = 1; i <= N; i++) {
            if(nums[i] == 1) {
                idx = 1;
                while(true) {
                    if (i * idx > N) break;

                    nums[i * idx] ^= 1;
                    idx++;
                }
                res++;
            }
        }

        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            if (nums[i] == 0) continue;
        
            flag = false;
            break;
        }

        System.out.print(flag ? res : -1);
        
    }
}
