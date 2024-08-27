package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_31846 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        char[] word = br.readLine().toCharArray();

        int Q = Integer.parseInt(br.readLine());
        int l, r, cnt, v1, v2;
        int res = 0;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            l = Integer.parseInt(st.nextToken()) - 1;
            r = Integer.parseInt(st.nextToken()) - 1;
            res = 0;
            for (int j = l; j < r; j++) {
                cnt = 0;
                v1 = j;
                v2 = j + 1;

                while (v1 >= l && v2 <= r) {
                    if (word[v1--] == word[v2++]) {
                        cnt++;
                    }
                }
                res = Math.max(res, cnt);
            }
            sb.append(res + "\n");
        }
        System.out.print(sb);
    }
}
