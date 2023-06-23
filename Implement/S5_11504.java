package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11504 {
    static int N, X, Y, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 1. X, Y 입력
            X = Integer.parseInt(br.readLine().replace(" ", ""));
            Y = Integer.parseInt(br.readLine().replace(" ", ""));

            String num = br.readLine().replace(" ", "");
            num += num.substring(0, N - 1);

            // 2. 탐색
            int std;
            int res = 0;
            for (int i = 0; i < N; i++) {
                std = Integer.parseInt(num.substring(i, i + M));

                if (std >= X && std <= Y)
                    res++;
            }

            sb.append(res + "\n");
        }
        
        System.out.print(sb.toString());
    }
}
