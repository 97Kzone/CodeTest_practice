package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_31430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        long a, b, v;

        if (T == 1) {
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            v = a + b;
            sb = new StringBuilder("aaaaaaaaaaaaa");
            for (int i = 0; i < 13; i++) {
                if (v > 0) {
                    sb.setCharAt(i, (char) ((v % 26) + 'a'));
                    v /= 26;
                } else
                    break;
            }
            System.out.print(sb);
        } else {
            String s = br.readLine();
            long res = 0;
            v = 1;

            for (int i = 0; i < s.length(); i++) {
                res += (s.charAt(i) - 'a') * v;
                v *= 26;
            }
            
            System.out.print(res);
        }
    }
}
