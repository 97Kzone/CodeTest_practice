package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_12871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int l1 = a.length();
        int l2 = b.length();

        int std;

        if (a.length() > b.length()) {
            std = gcd(l1, l2);
        } else {
            std = gcd(l2, l1);
        }

        int v = (l1 * l2) / std;

        String na = a.repeat(v / l1);
        String nb = b.repeat(v / l2);

        if (na.equals(nb)) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }

    static int gcd(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        }
        return gcd(n2, n1 % n2);
    }
}
