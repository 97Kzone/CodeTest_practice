package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_33049 {

    static int P3, P4, P0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        P3 = Integer.parseInt(st.nextToken());
        P4 = Integer.parseInt(st.nextToken());
        P0 = Integer.parseInt(st.nextToken());

        int tmp1, tmp2;
        for (int i = 0; i <= P0; i++) {
            tmp1 = P3 + i;
            tmp2 = P4 + P0 - i;

            if ((tmp1 % 3 == 0) && (tmp2 % 4 == 0)) {
                System.out.print(tmp1 / 3 + " " + tmp2 / 4);
                return;
            }
        }

        System.out.print(-1);
    }
}
