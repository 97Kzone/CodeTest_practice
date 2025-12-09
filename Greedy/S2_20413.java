package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_20413 {

    static int N, S, G, P, D;
    static char[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        rank = br.readLine().toCharArray();

        int res = 0;
        int std = 0;

        for (int i = 0; i < N; i++) {
            if (rank[i] == 'B') {
                res += (S - 1) - std;
                std = (S - 1) - std;
            } else if (rank[i] == 'S') {
                res += (G - 1) - std;
                std = (G - 1) - std;
            } else if (rank[i] == 'G') {
                res += (P - 1) - std;
                std = (P - 1) - std;    
            } else if (rank[i] == 'P') {
                res += (D - 1) - std;
                std = (D - 1) - std;
            } else if (rank[i] == 'D') {
                res += D;
                std = D;
            }
        } 

        System.out.print(res);
    }
}
