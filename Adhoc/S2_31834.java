package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_31834 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N, S, E;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            if ((S == 1 && E == N) ||
                (S == N && E == 1)) {
                sb.append("0" + "\n");
            } else if (1 < S && S < N) {
                sb.append(Math.abs(S - E) == 1 ? "1" : "2").append("\n");
            } else if (1 < E && E < N) {
                sb.append("1" + "\n");
            }
        }
        
        System.out.print(sb);
    }
}
