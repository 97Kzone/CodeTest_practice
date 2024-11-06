package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_24314 {

    static int a1, a2, C, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a1 = Integer.parseInt(st.nextToken());
        a2 = Integer.parseInt(st.nextToken());
        
        C = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        int res = 1;
        for (int i = n; i <= 100; i++) {
            if (C * i <= a1 * i + a2)
                continue;

            res = 0;
            break;
        }
        System.out.print(res);
    }
}
