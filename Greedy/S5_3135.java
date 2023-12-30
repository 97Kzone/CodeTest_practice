package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_3135 {

    static int A, B, N, std;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        std = Math.abs(A - B);

        int tmp;
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(br.readLine());
            std = Math.min(std, Math.abs(B - tmp) + 1);
        }

        System.out.print(std);
    }
}
