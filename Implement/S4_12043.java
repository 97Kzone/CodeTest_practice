package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S4_12043 {

    static final int mod = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        String s;
        int n;
        long res;

        Set<Character> set;
        for (int t = 1; t <= T; t++) {
            s = br.readLine();
            n = s.length();
            
            if (n == 1) res = 1;
            else {
                res = (s.charAt(0) != s.charAt(1) ? 1 : 0) + 1;
                res *= (s.charAt(n - 1) != s.charAt(n - 2) ? 1 : 0) + 1;

                for (int i = 1; i < n - 1; i++) {
                    set = new HashSet<>();
                    set.add(s.charAt(i - 1));
                    set.add(s.charAt(i));
                    set.add(s.charAt(i + 1));
                    res = (res * set.size()) % mod;
                }
            }

            bw.write("Case #" + t + ": " + res + "\n");
        }

        bw.flush();
        bw.close();
    }
}
