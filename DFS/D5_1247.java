package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D5_1247 {
    static int N;
    static int std = 987654321;
    static ArrayList<int[]> target; // 회사, 집, 방문할 곳 좌표
    static int[][] graph, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            N += 2;
            target = new ArrayList<>();
            graph = new int[N][N];
            dist = new int[N][1 << N];

            for (int i = 0; i < N; i++) Arrays.fill(dist[i], std);

            st = new StringTokenizer(br.readLine());
            int x, y;
            for (int i = 0; i < N; i++) {
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                target.add(new int[] {x, y});
            }

            setDist(); // 각 좌표별 거리 계산
            int res = check(0, 1); // 최소 거리 계산
            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    // 외판원 순회
    static int check(int idx, int visit) {
        if (visit == (1 << N) - 1) {
            dist[idx][visit] = graph[idx][1];
            return graph[idx][1];
        }

        if (dist[idx][visit] != std) return dist[idx][visit];

        for (int i = 1; i < N; i++) {
            if ((visit & (1 << i)) != 0) continue;

            dist[idx][visit] = Math.min(dist[idx][visit], check(i, visit | (1 << i)) + graph[idx][i]);
        }

        return dist[idx][visit];
    }

    // 좌표별 거리 세팅
    static void setDist() {
        int v;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                v = checkDist(i, j);  
                graph[i][j] = v;
                graph[j][i] = v;
            }
        }
    }

    // 거리 계산
    static int checkDist(int i, int j) {
        return Math.abs(target.get(i)[0] - target.get(j)[0]) +
               Math.abs(target.get(i)[1] - target.get(j)[1]); 
    }
}
