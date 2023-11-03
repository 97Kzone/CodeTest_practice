package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_2303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[5];
        int[] list = new int[N];

        int max;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }

            max = -2000000000;

            for (int j = 0; j < 3; j++) {
                for (int k = j + 1; k < 4; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        max = Math.max(max, (nums[j] + nums[k] + nums[l]) % 10);
                    }
                }
            }
            list[i] = max;
        }

        int idx = -1, res = -1;
        for (int i = 0; i < N; i++) {
            if (res <= list[i]) {
                res = list[i];
                idx = i + 1;
            }
        }

        System.out.print(idx);
    }
}
