package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_25379 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int l = 0, r = 0;
        int res = 0, idx = 0;
        int std;
        for (int i = 0; i < N; i++) {
            std = Integer.parseInt(st.nextToken());

            if (std % 2 == 0) {
                res += idx;
                idx++;
                l += i;
                r += N - 1 - i;
            }
        }

        System.out.println(Math.min(l, r) - res);
    }
}
