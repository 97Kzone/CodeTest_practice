package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_28278 {
    
    static int[] stack;
    static int ptr = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        stack = new int[N];

        int cmd, val;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                val = Integer.parseInt(st.nextToken());
                stack[ptr++] = val;
            } else if (cmd == 2) {
                sb.append(ptr == 0 ? -1 : stack[--ptr]).append("\n");
            } else if (cmd == 3) {
                sb.append(ptr).append("\n");
            } else if (cmd == 4) {
                sb.append(ptr == 0 ? 1 : 0).append("\n");
            } else if (cmd == 5) {
                sb.append(ptr == 0 ? -1 : stack[ptr - 1]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
