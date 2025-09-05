package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_33710 {

    static int N, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String s = br.readLine();
        
        res = 100;
        check(s, K);

        System.out.print(res);
    }

    static void check(String s, int cnt) {
        int l = s.length();
        res = Math.min(res, l);

        if (cnt == 0) return;

        String tmp;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (s.charAt(i) != s.charAt(j) || s.charAt(i) == 'X') continue;

                tmp = s.substring(0, i) + s.substring(j + 1, l);
                
                check(tmp, cnt - 1);
            }
        }
    }
}