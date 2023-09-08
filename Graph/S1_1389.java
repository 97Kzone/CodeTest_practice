package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_1389 {

    static int N, M;
    static int[][] graph, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(graph[i], 1000);
            graph[i][i] = 0;
        }

        int s, e;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph[s][e] = 1;
            graph[e][s] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int res1 = 0, res2 = 1000; // 번호, 수
        int cnt;
        for (int i = 1; i < N + 1; i++) {
            cnt = 0;

            for (int j = 1; j < N + 1; j++) {
                cnt += graph[i][j];
            }

            if (cnt < res2) {
                res2 = cnt;
                res1 = i;
            }
        }

        System.out.print(res1);
    }
}
