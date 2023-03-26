package UDP_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static int u, d, p, c;
    static String res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] vote = br.readLine().toCharArray();

        for (char c : vote) {
            if (c == 'U' || c == 'C') {
                u++;
                c++;
            } else {
                p++;
                d++;
            }
        }

        res = "U";

        if (u == d) {
            res += "DP";
        } else if (u < d) {
            res = "DP";
        } else {
            res = "C";
        }

        System.out.println(res);
    }

}
