package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_32335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        int idx = 0;
        int now;
        while (idx < N) {
            now = s.charAt(idx) - '0';

            if (idx == N - 1) {
                now = (now + M) % 10;
                sb.append(now);
                break;
            }

            if (now == 0) {
                idx++;
                sb.append(0);
            } else {
                if (10 - now > M) {
                    idx++;
                    sb.append(now);
                    continue;
                }

                M -= (10 - now);
                sb.append(0);
                idx++;
            }
        }
        System.out.print(sb);
    }
}
