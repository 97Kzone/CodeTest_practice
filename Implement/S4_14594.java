package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_14594 {

    static int N, M;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        check = new boolean[N];
        Arrays.fill(check, true);

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            for (int j = a; j < b; j++) {
                check[j] = false;
            }
        }
        
        int res = 1;
        for (int i = 1; i < N; i++) {
            res += check[i] ? 1 : 0;
        }

        System.out.print(res);
    }
}
