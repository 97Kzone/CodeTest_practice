package Implement;

import java.io.*;
import java.util.*;

public class S3_33925 {

    static int N, J, S, H, K;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        J = Integer.parseInt(st.nextToken()); 
        S = Integer.parseInt(st.nextToken()); 
        H = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 

        map = new char[3][N];
        for (int i = 0; i < 3; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[] hurdles = new int[3]; 

        for (int i = 0; i < N; i++) {
            char top = map[0][i];
            char mid = map[1][i];
            char bot = map[2][i];

            if (top == '.' && mid == '.' && bot == '.') continue;
            if (mid == '^' && bot == '^') hurdles[1]++;
            else if (bot == '^') hurdles[0]++;
            else if (top == 'v') hurdles[2]++;
        }

        S -= hurdles[2];
        if (S < 0) H -= (-S) * K;

        J -= hurdles[0];
        if (J < 0) {
            H -= (-J) * K;
            J = 0;
        }

        J -= hurdles[1] * 2;
        if (J < 0) H -= ((-J + 1) / 2) * K;

        System.out.println(H > 0 ? H : -1);
    }
}
