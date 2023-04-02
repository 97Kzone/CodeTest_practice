package GahuiCup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        res = 0;
        String s = "";
        while ((s = br.readLine()) != null) {
            st = new StringTokenizer(s, " ");

            if ("Es".equals(st.nextToken())) {
                res += Integer.parseInt(st.nextToken()) * 21;
            } else {
                res += Integer.parseInt(st.nextToken()) * 17;
            }
        }
        System.out.println(res);

    }
}
