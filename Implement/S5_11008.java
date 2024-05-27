package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int res, l;
        String s1, s2;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            s1 = st.nextToken();
            s2 = st.nextToken();

            l = s1.length();
            res = 0;

            s1 = s1.replaceAll(s2, "");
            res += (l - s1.length()) / s2.length();
            res += s1.length();

            sb.append(res + "\n");
        }
        System.out.print(sb);
    }
}
