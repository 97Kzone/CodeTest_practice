package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class G5_20164 {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        check(N, 0);
        
        System.out.println(min + " " + max);
    }
    
    static void check(int n, int cnt) {
        cnt += countOdd(n);
        
        if (n / 10 == 0) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        } else if (n / 100 == 0) {
            int next = n / 10 + n % 10;
            check(next, cnt);
        } else {
            String s = String.valueOf(n);
            for (int i = 0; i < s.length() - 2; i++) {
                for (int j = i + 1; j < s.length() - 1; j++) {
                    int next = Integer.parseInt(s.substring(0, i + 1));
                    next += Integer.parseInt(s.substring(i + 1, j + 1));
                    next += Integer.parseInt(s.substring(j + 1));
                    
                    check(next, cnt);
                }
            }
        }
    }
    
    static int countOdd(int n) {
        int cnt = 0;
        while (n > 0) {
            int tmp = n % 10;
            if (tmp % 2 == 1) {
                cnt++;
            }
            n /= 10;
        }
        
        return cnt;
    }
}
