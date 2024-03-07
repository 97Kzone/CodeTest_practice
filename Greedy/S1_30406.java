package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_30406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[Integer.parseInt(st.nextToken())]++;
        }
        
        int res = 0;

        // 1. 0 - 3 
        while (true) {
            if (nums[0] > 0 && nums[3] > 0) {
                res += 3;
                nums[0]--;
                nums[3]--;
            } else break;
        }

        // 2. 1 - 2
        while (true) {
            if (nums[1] > 0 && nums[2] > 0) {
                res += 3;
                nums[1]--;
                nums[2]--;
            } else break;
        }
        
        // 3. 0 잔반처리
        while (true) {
            if (nums[0] > 0 && nums[2] > 0) {
                res += 2;
                nums[0]--;
                nums[2]--;
            } else {
                if (nums[0] > 0 && nums[1] > 0) {
                    res += 1;
                    nums[0]--;
                    nums[1]--;
                } else break;
            }
        }
        
        // 4. 1 잔반처리
        while (true) {
            if (nums[1] > 0 && nums[3] > 0) {
                res += 2;
                nums[1]--;
                nums[3]--;
            } else {
                if (nums[1] > 0 && nums[0] > 0) {
                    res += 1;
                    nums[1]--;
                    nums[0]--;
                } else
                    break;
            }
        }

        // 5. 2 잔반처리
        while (true) {
            if (nums[2] > 0 && nums[0] > 0) {
                res += 2;
                nums[2]--;
                nums[0]--;
            } else {
                if (nums[2] > 0 && nums[3] > 0) {
                    res += 1;
                    nums[2]--;
                    nums[3]--;
                } else break;
            }
        }

        // 6. 3 잔반처리
        while (true) {
            if (nums[3] > 0 && nums[1] > 0) {
                res += 2;
                nums[3]--;
                nums[1]--;
            } else {
                if (nums[3] > 0 && nums[2] > 0) {
                    res += 1;
                    nums[3]--;
                    nums[2]--;
                } else break;
            }
        }

        System.out.print(res);
    }
}
