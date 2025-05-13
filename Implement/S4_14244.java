package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_14244 {

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int leaf = 0;
        if (M == 2) {
            leaf = 1;
        }

        int last = 0;
        for (int i = 1; i < N; i++) {
            if (M > leaf) {
                sb.append(0 + " " + i).append("\n");
                leaf++;
            } else {
                sb.append(last + " " + i).append("\n");
            }
            last = i;
        }

        System.out.print(sb.toString());
    }
}
