package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_31825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        String S = br.readLine();

        int a, b, c, cnt;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;

            // 1. 문자열 묶음 따지기
            if (a == 1) {
                cnt = 1;
                char std = S.charAt(b);
                for (int j = b + 1; j <= c; j++) {
                    if (S.charAt(j) != std) {
                        std = S.charAt(j);
                        cnt++;
                    }
                }
                sb.append(cnt + "\n");
            } else {
                String tmp = S.substring(0, b);
                for (int j = b; j <= c; j++) {
                    a = S.charAt(j) - 0;
                    if (a == 90) {
                        tmp += "A";
                    } else {
                        tmp += (char) (a + 1) ;
                    }
                }
                tmp += S.substring(c + 1, N);
                S = tmp;
            }

        }
        System.out.print(sb);
    }
}
