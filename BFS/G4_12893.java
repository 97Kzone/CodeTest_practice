package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_12893 {
    static int N, M, res;
    static ArrayList<Integer>[] graph;
    static int[] enemy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        enemy = new int[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }

        res = 1;
        bfs();
        System.out.print(res);
    }

    static void bfs() {
        Queue<Integer> q;
        for (int i = 1; i < N+1; i++) {
            if (enemy[i] == 0) {
                q = new LinkedList<>();
                q.offer(i);
                enemy[i] = 1;

                while (!q.isEmpty()) {
                    int now = q.poll();

                    for (int nxt : graph[now]) {
                        if (enemy[nxt] == 0) {
                            enemy[nxt] = enemy[now] * -1;
                            q.offer(nxt);
                        } else if (enemy[now] == enemy[nxt]) {
                            res = 0;
                            return;
                        }
                    }
                }
            }
        }

    }
}
