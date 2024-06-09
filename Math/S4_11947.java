package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_11947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        String s;
        int l;
        long res = 0;
        for (int t = 0; t < T; t++) {
            s = br.readLine();
            l = s.length();

            long v1 = 0;
            if (s.charAt(0) >= '5') {
                v1 = Long.parseLong("5" + "0".repeat(l - 1));
                res = v1 * (v1 - 1);
            } else {
                v1 = Long.parseLong("9".repeat(l)) - Long.parseLong(s);
                res = v1 * Long.parseLong(s);
            }
                    
            sb.append(res + "\n");
        }

        System.out.print(sb);
    }
}
