package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_20364 {

    static int N, Q;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];

        int n, std;
        boolean flag;
        for (int i = 0; i < Q; i++) {
            n = Integer.parseInt(br.readLine());

            flag = false;
            std = 1;
            for (int j = n; j >= 2; j /= 2) {
                if (!visit[j]) continue;
                flag = true;
                std = j;
            }

            if (flag) {
                sb.append(std);
            } else {
                visit[n] = true;
                sb.append(0);
            }

            sb.append("\n");
        }   

        System.out.print(sb.toString());
    }
}
