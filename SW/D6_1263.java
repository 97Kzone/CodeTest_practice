import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D6_1263 {
    static int std = 987654321;
    static int N, res;

    static int[][] graph, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            // dp = new int[N][N];
            graph = new int[N][N];

            for (int i = 0; i < N; i++) Arrays.fill(graph[i], std);

            int tmp;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tmp = Integer.parseInt(st.nextToken());
                    if (i == j || tmp == 0) continue;
                    
                    graph[i][j] = tmp;
                }
            }
            
            res = 987654321;
            check();
            sb.append("#" + t + " ").append(res + "\n");


        }
        System.out.println(sb.toString());
    }

    // 플로이드 와샬
    static void check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int cnt;
        for (int i = 0; i < N; i++) {
            cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                cnt += graph[i][j];
            }

            if (cnt < res) {
                res = cnt;
            }

        }
    }
}
