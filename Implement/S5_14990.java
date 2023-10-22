package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_14990 {
    static int N, M;
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        String res = "";

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        int gcd = GCD(Math.max(N, M), Math.min(N, M));
        
        res = N / gcd + ":" + M / gcd;
        System.out.println(res);
    }
 
    private static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
 
        return GCD(b, a % b);
    }
}
