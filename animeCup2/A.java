package animeCup2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    static int N, M;
    static int[] r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        r = new int[N];
        c = new int[M];

        for (int i = 0; i < N-1; i++) {
            r[i] = Integer.parseInt(br.readLine());
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            c[j] = Integer.parseInt(st.nextToken());
        }

        r[N-1] = c[0];
        int rs = 51;
        int ri = 0;
        int cs = 51;
        int ci = 0;

        for (int i = 0; i < N; i++) {
            if (rs > r[i]) {
                rs = r[i];
                ri = i;
            } 
        }

        for (int j = 0; j < M; j++) {
            if (cs > c[j]) {
                cs = c[j];
                ci = j;
            } 
        }
        ri++;
        ci++;
        System.out.print(ri + " " + ci);
    }
}
