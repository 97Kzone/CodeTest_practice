package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_25632 {

    static int A, B, C, D;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        init();
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int acnt = 0, bcnt = 0, std = 0; // YT, YJ, 공유
        boolean flag1, flag2;
        for (int i = 1; i <= 1000; i++) {
            if (prime[i]) {
                flag1 = false;
                flag2 = false;

                if (A <= i && i <= B) {
                    acnt++;
                    flag1 = true;
                }

                if (C <= i && i <= D) {
                    bcnt++;
                    flag2 = true;
                }

                if (flag1 && flag2)
                    std++;
            }
        }

        if (std == 0) {
            System.out.print(acnt > bcnt ? "yt" : "yj");
        } else {
            if (std % 2 == 0) System.out.print(acnt > bcnt ? "yt" : "yj");
            else System.out.print(acnt >= bcnt ? "yt" : "yj");
        }
    }
    
    static void init() {
        prime = new boolean[1001];
        Arrays.fill(prime, true);
        for (int i = 2; i * i <= 1000; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 1000; j += i) prime[j] = false;
            }
        }
    }
}
