package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_10837 {

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int max, a, b;
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if (N == M) {
                sb.append("1" + "\n");
                continue;
            }

            max = Math.max(N, M);
            a = K - max;
            b = Math.abs(N - M);

            if (M > N) {
                sb.append(b - a <= 2 ? 1 : 0).append("\n");
            } else {
                sb.append(b - a <= 1 ? 1 : 0).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
