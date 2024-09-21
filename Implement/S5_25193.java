package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_25193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'C') {
                cnt++;
            }
        }

        int v1 = cnt / (N - cnt + 1);
        int v2 = cnt % (N - cnt + 1);

        if (v2 != 0) {
            v2 = 1;
        }

        System.out.print(v1 + v2);
        
    }
}
