package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_21760 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N, M, k, D, std;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            std = D * 2 / (k * N * M * (M - 1) + M * M * N * (N - 1));

            if (std != 0) {
                sb.append(M * (M - 1) * N * k * std / 2 + M * M * N * (N - 1) * std / 2).append("\n");
            } else {
                sb.append(-1 + "\n");
            }
        }
        System.out.print(sb);
    }
}
