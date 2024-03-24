package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_18004 {

    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        // 1. a == b 
        if (a == b) {
            System.out.print(0);
            return;
        }
        
        // 2. a < b
        if (a < b) {
            System.out.print(b - a);
            return;
        }
        
        // 3. a > b
        int res = 0;
        while (a > b) {
            if (a % 2 == 1) a += 1;
            else a /= 2; 
            res++;
        }
        
        res += b - a;
        System.out.print(res);
    }
}
