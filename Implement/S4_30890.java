package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_30890 {

    static int X, Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int std = lcm(X, Y);
        int a = std / X;
        int b = std / Y;

        for (int i = 1 ; i <= std; i++) {
            if (i % a == 0 && i % b != 0) sb.append(1);
            else if (i % a != 0 && i % b == 0) sb.append(2);
            else if (i % a == 0 && i % b == 0) sb.append(3);
        }

        System.out.print(sb.toString());
    }

    static int gcd(int a, int b) {
        int tmp;
        while(b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
