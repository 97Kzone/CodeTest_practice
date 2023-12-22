package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_25947 {

    static int N, B, A;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    
        Arrays.sort(nums);

        int l = 0, r = 0;
        boolean flag = true;

        int res = 0;
        for (int i = 0; i < A; i++) {
            B -= nums[i] / 2;
            r = i + 1;
            if (B < 0) {
                flag = false;
                res = i;
                break;
            }
        }

        if (flag) {
            while (r < N) {
                if (r - l < A) {
                    B -= nums[r] / 2;
                    if (B < 0)
                        break;
                    r++;
                } else {
                    if (A > 0) {
                        B -= nums[l++] / 2;
                    } else {
                        B -= nums[r];
                        if (B < 0)
                            break;
                        r++;
                    }
                }
            }
            res = r;
        }

        System.out.print(res);
    }
}
