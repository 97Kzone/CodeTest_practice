package GAJI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    static int N, M, K;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];

        // 무너지면 바로 break;
        int t, r;
        int res = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            nums[1] += r;
            if (nums[1] > K && res == 0) {
                res = i + 1;
            }
        }

        if (res == 0) {
            System.out.println(-1);
        } else {
            System.out.println(res + " " + 1);
        }
    }
}
