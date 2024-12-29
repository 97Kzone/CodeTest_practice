package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_12971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P1 = Integer.parseInt(st.nextToken());
        int P2 = Integer.parseInt(st.nextToken());
        int P3 = Integer.parseInt(st.nextToken());
        int X1 = Integer.parseInt(st.nextToken());
        int X2 = Integer.parseInt(st.nextToken());
        int X3 = Integer.parseInt(st.nextToken());

        int res = 0;
        for (int i = 1; i <= P1 * P2 * P3; i++) {
            if (i % P1 == X1 && i % P2 == X2 && i % P3 == X3) {
                res = i;
                break;
            }
        }

        System.out.print(res == 0 ? -1 : res);
    }
}
