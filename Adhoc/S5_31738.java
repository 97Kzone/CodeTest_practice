package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_31738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N >= M) {
            System.out.print(0);
            return;
        }

        if (N >= M * 2) {
            System.out.print(0);
            return;
        }

        int res = 1;
        for (int i = 1; i <= N; i++) {
            res = (res * i) % M;
        }

        System.out.print(res);
    }

}
