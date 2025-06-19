package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int res = Integer.MAX_VALUE;

        int al = a.length();
        int bl = b.length();
        int cnt;
        for (int i = 0; i <= bl - al; i++) {
            cnt = 0;
            for (int j = 0; j < al; j++) {
                if (a.charAt(j) == b.charAt(i + j)) continue;
                cnt++;
            }
            res = Math.min(res, cnt);
        }

        System.out.print(res);

    }
}
