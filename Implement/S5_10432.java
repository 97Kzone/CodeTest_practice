package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_10432 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());
        int[] nums = new int[12];
        boolean flag;
        int tmp, res;
        for (int t = 1; t <= P; t++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int i = 0; i < 12; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            res = 0;
            for (int i = 0; i < 12; i++) {
                for (int j = i + 2; j < 12; j++) {
                    flag = true;

                    tmp = Math.max(nums[i], nums[j]);

                    for (int k = i + 1; k < j; k++) {
                        if (nums[k] <= tmp) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag)
                        res++;
                }
            }
            sb.append(t + " " + res + "\n");
        }
        System.out.print(sb);
    }
}
