package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_20529 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int res;
        String[] s;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            res = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            if (N > 32) {
                sb.append(0 + "\n");
                continue;
            }

            s = new String[N];
            for (int i = 0; i < N; i++) {
                s[i] = st.nextToken();
            }

            int cnt;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        cnt = 0;

                        for (int a = 0; a < 4; a++) {
                            if (s[i].charAt(a) != s[j].charAt(a)) cnt++;
                            if (s[j].charAt(a) != s[k].charAt(a)) cnt++;
                            if (s[k].charAt(a) != s[i].charAt(a)) cnt++;
                        }
                        
                        res = Math.min(res, cnt);
                    }
                }
            }
            sb.append(res + "\n");
        }
        System.out.print(sb);
    }
}
