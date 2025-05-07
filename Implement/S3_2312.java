package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_2312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int N;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            for (int i = 2; i * i <= N; i++) {
                int count = 0;
                while (N % i == 0) {
                    count++;
                    N /= i;
                }

                if (count > 0) {
                    sb.append(i).append(" ").append(count).append("\n");
                }
            }

            if (N > 1) {
                sb.append(N).append(" 1\n");
            }
        }

        System.out.print(sb);
    }
}
