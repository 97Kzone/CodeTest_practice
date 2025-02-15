package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_25375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int Q = Integer.parseInt(br.readLine());

        long a, b;
        for (int i = 0 ; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());

            if (b % a == 0 && b / a != 1) {
                sb.append(1 + "\n");
            } else{
                sb.append(0 + "\n");
            }
        }

        System.out.print(sb.toString());
    }
}
