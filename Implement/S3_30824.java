package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_30824 {

    static long[] fib;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        init();

        int T = Integer.parseInt(br.readLine());
        
        int k;
        long x;
        boolean flag;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            
            k = Integer.parseInt(st.nextToken());
            x = Long.parseLong(st.nextToken());

            flag = check(k, x);
            sb.append(flag ? "YES" : "NO").append("\n");
        }

        System.out.print(sb.toString());
        
    }

    static boolean check(int k, long x) {
        if (k == 1) {
            for (long v : fib) {
                if (v > x)  break;
                if (v == x) return true;
            }
        } else if (k == 2) {
            for (long v1 : fib) {
                if (v1 > x) break;
                for (long v2 : fib) {
                    if (v1 + v2 > x) break;
                    if (v1 + v2 == x) return true;
                }
            }
        } else {
            for (long v1 : fib) {
                if (v1 > x) break;
                for (long v2 : fib) {
                    if (v1 + v2 > x) break;
                    for (long v3 : fib) {
                        if (v1 + v2 + v3 > x) break;
                        if (v1 + v2 + v3 == x) return true;
                    }
                }
            }
        }

        return false;
    }

    static void init() {
        fib = new long[79];
        fib[0] = fib[1] = 1;

        for (int i = 2; i < 79; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
    }
}
