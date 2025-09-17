package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1_19563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a, b, c;
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        a = Math.abs(a);
        b = Math.abs(b);
        String res = "";
        if (a + b > c) {
            res = "NO";
        } else {
            if ((a + b) % 2 == 0 && c % 2 == 0) {
                res = "YES";
            } else if ((a + b) % 2 == 1 && c % 2 == 1) {
                res = "YES";
            } else {
                res = "NO";
            }
        }

        System.out.print(res);
    }
}
