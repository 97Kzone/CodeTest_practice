package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_32218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        int[] tmp;
        while (true) {
            res++;
            tmp = new int[N];

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (nums[i] < nums[j]) {
                        tmp[i]++;
                    }
                }
            }

            boolean flag = true;
            for (int i = 0; i < N; i++) {
                if (nums[i] != tmp[i]) {
                    flag = false;
                }
            }

            if (flag) {
                break;
            }

            nums = Arrays.copyOf(tmp, N);
        }
        System.out.print(res);
    }
}
