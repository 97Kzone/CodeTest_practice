package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_3061 {

    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int res = 0;
            int tmp;
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (nums[j - 1] > nums[j]) {
                        tmp = nums[j - 1];
                        nums[j - 1] = nums[j];
                        nums[j] = tmp;
                        res++;
                    }
                }
            }

            sb.append(res + "\n");
        }

        System.out.print(sb);
    }
}
