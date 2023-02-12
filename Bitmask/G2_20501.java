package Bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_20501 {
    static int N, M;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1]; // 1 부터 N

        for (int i = 1; i < N+1; i++) {
            String s = br.readLine();
            nums[i] = Integer.parseInt(s, 2);
        }

        M = Integer.parseInt(br.readLine());
        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(check(a, b)).append("\n");
        }
        System.out.print(sb.toString());
    }

    static int check(int a, int b) {
        int tmp = nums[a] & nums[b];
        if (tmp == 0) return 0;

        int cnt = 0;
        for (int i = 1; i < 1 << N; i++) {
            if ((tmp & i) == i) cnt++;
        }

        return cnt;
    }
}