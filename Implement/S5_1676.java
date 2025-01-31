package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        int res = 0;
        for (int i = 0; i <= N; i++) {
            res += check(i);
        }
        System.out.print(res);
    }
    
    static int check(int n) {
        if (n == 0) return 0;

        return n % 5 == 0 ? 1 + check(n/5) : 0;
    }
}
