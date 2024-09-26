package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G1_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int l = 1;
        int r = K;

        int res = 0;
        int m, cnt;
        while (true) {
            if (l > r)
                break;

            m = (l + r) / 2;
            cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, m / i);
            }

            if (cnt >= K) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        System.out.print(res);

    }
}
