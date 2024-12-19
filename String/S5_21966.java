package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_21966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        boolean flag = true;
        if (N <= 25) {
            sb.append(s);
        } else {
            String tmp = s.substring(12, N - 12);

            for (char c : tmp.toCharArray()) {
                if (c == '.') {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append(s.substring(0, 11) + "..." + s.substring(N - 11));
            } else {
                sb.append(s.substring(0, 9) + "......" + s.substring(N - 10));
            }
        }
        System.out.print(sb);
    }
}
