package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class S4_9471 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());

        int N, M, a, b, tmp;
        long res;
        for (int p = 1; p <= P; p++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            res = 1;
            a = 1;
            b = 2;
            while(true) {
                if (a % M == 1 && b % M == 1) break;

                res++;
                tmp = a + b;
                a = b;
                b = tmp % M;
            }

            bw.write(N + " " + res + "\n");
        }

        bw.flush();
        bw.close();
    }
}
