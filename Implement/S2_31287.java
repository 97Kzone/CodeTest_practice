package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_31287 {

    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        int x = 0, y = 0;
        boolean flag = false;
        int check = 0;
        for (int t = 0; t < K; t++) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'U') {
                    x++;
                } else if (s.charAt(i) == 'D') {
                    x--;
                } else if (s.charAt(i) == 'L') {
                    y++;
                } else if (s.charAt(i) == 'R') {
                    y--;
                }
    
                if (x == 0 && y == 0) {
                    flag = true;
                    break;
                }
                check++;
            }
            if (check > 5000000) break;
        }

        System.out.print(flag ? "YES" : "NO");
    }
}
