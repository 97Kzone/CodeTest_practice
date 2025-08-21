package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_15738 {

    static int N, K, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int cmd;
        for (int i = 0; i < M; i++) {
            cmd = Integer.parseInt(br.readLine());

            if (cmd > 0) {
                if (K <= cmd) K = cmd - K + 1;
            } else {
                if (K > cmd + N) K = N + cmd - (K - 1 - N);
            }
        }

        System.out.print(K);
    }
}
