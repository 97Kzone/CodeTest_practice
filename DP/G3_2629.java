package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이게 맞나?
public class G3_2629 {
    static int N, M;

    static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        boolean[][] check = new boolean[N+1][40001];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            int v = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 40001; j++) {
                if(check[i-1][j]) {
                    check[i][j] = true;
                    check[i][j + v] = true;
                    check[i][Math.abs(j - v)] = true;
               }
            }
            check[i][v] = true;
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int v = Integer.parseInt(st.nextToken());

            sb.append((check[N][v]) ? "Y " : "N ");
        }
        System.out.println(sb.toString());
        
    }
    public static void main(String[] args) throws IOException {
        sol();
    }
}
