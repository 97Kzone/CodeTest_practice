package SW_Bclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9843 {

    static Long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Long.parseLong(br.readLine());

            long res = check();
            sb.append("#" + t + " ").append(res + "\n");
        }

        System.out.print(sb.toString());
    }
    
    static long check() {
            long l = 0, r = (long) Math.sqrt(2 * (double) N);
            long m, sum;

            while (l <= r) {
                m = l + (r - l) / 2;
                sum = m * (m + 1) / 2;

                if (sum == N) {
                    return m;
                } else if (sum < N) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

            return -1;
    }
}
