package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_18291 {

    static final int VALUE = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int N;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            if (N == 1) {
                sb.append(1 + "\n");
                continue;
            }

            sb.append(check(N - 2) + "\n");
        }

        System.out.print(sb);
    }
    
    static long check(int std) {
        if (std == 0) return 1;

        long tmp = check(std / 2);
        tmp = (tmp * tmp) % VALUE;

        return std % 2 == 0 ? tmp : (tmp * 2) % VALUE;
    }
}
