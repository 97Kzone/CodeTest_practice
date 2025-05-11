package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_18917 {

    static long sum;
    static long xor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        int cmd, v;
        sum = 0;
        xor = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                v = Integer.parseInt(st.nextToken());
                sum += v;
                xor ^= v;
            } else if (cmd == 2) {
                v = Integer.parseInt(st.nextToken());
                sum -= v;
                xor ^= v;
            } else if (cmd == 3) {
                sb.append(sum + "\n");
            } else if (cmd == 4) {
                sb.append(xor + "\n");
            }
        }

        System.out.print(sb.toString());
    }
}
