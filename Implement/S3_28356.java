package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_28356 {

    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[2][M];

        int K = 4;
        int cnt = -1;
        int tmp;
        if (N == 1 && M == 1) K = 1;
        else if (N == 1 || M == 1) K = 2;
        
        for (int i = 0; i < 2; i++) {
            if (i == N)
                break;

            for (int j = 0; j < M; j++) {
                cnt++;
                map[i][j] = (cnt % K) + 1;
            }
            tmp = ((cnt + 1) + (M % 1)) == 1 ? 1 : 0;
            cnt = tmp % K + 1;
        }

        sb.append(K + "\n");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i%2][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
