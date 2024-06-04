package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_30020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean flag = true;
        int cnt = 0;
        while (true) {
            if (a <= 0 || b <= 0) {
                flag = false;
                break;
            }

            if (a <= b) {
                flag = false;
                break;
            }

            if (a - b == 1) {
                break;
            }

            a -= 2;
            b -= 1;
            cnt++;
            sb.append("aba" + "\n");
        }

        for (int i = 0; i < (a + b) / 2; i++) {
            sb.append("ab");
        }
        sb.append("a");

        if (flag) {
            cnt++;
            System.out.println("YES");
            System.out.println(cnt);
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}
