package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_29715 {

    static int N, M, X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int a, b;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a == 0) cnt1++;
            else cnt2++;
        }

        N -= cnt2;
        int res = 1;

        if (cnt1 > 0) res *= comb(N, cnt1) * check(cnt1);
        N -= cnt1;

        if (N > 0) res *= perm(9 - (cnt1 + cnt2), N);
        
        System.out.print(res * X + ((res - 1) / 3) * Y);
    }
    
    static int comb(int n, int k) {
        if (k > n)
            return 0;

        return check(n) / (check(k) * check(n - k));
    }

    static int perm(int n, int k) {
        return check(n) / check(n - k);
    }

    static int check(int n) {
        if (n == 0) {
            return 1;
        }

        int a = 1;
        for (int i = 1; i <= n; i++) {
            a *= i;
        }

        return a;
    }
}
