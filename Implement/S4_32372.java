package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_32372 {

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int x = 1, y = 1;
        
        int a, b, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            if (c == 1 || c == 5) {
                y = b;
            }
            if (c == 3 || c == 7) {
                x = a;
            }
            if (c == 1 || c == 2 || c == 8) {
                x = Math.min(x, a + 1);
            }
            if (c == 4 || c == 5 || c == 6) {
                x = Math.max(x, a + 1);
            }
            if (c == 6 || c == 7 || c == 8) {
                y = Math.min(y, b + 1);
            }
            if (c == 2 || c == 3 || c == 4) {
                y = Math.max(y, b + 1);
            }
        }
        
        System.out.println(x + " " + y);
    }
}
