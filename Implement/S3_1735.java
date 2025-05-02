package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_1735 {

    static int A1, A2, B1, B2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A1 = Integer.parseInt(st.nextToken());
        B1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A2 = Integer.parseInt(st.nextToken());
        B2 = Integer.parseInt(st.nextToken());

        int X = (A1 * B2) + (A2 * B1);
        int Y = B1 * B2;

        int v = gcd(X, Y);
        System.out.println(X / v + " " + Y / v);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    } 
}
