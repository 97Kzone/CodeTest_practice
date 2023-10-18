package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_14912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int res = 0;
        for (int i = 1; i <= N; i++) {
            res += check(i, D);
        }

        System.out.println(res);
    }

    static int check(int n, int d) {
        int cnt = 0;

        while (n != 0) {
            if (n % 10 == d) {
                cnt++;
            }

            n /= 10;
        }

        return cnt;
    }
}
