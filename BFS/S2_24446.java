package BFS;

import java.io.*;
import java.util.*;

public class S2_24446 {

    static int N, M, R;
    static int[] visit;
    static ArrayList<Integer>[] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            board[i] = new ArrayList<>();
        }

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            board[s].add(e);
            board[e].add(s);
        }

        check();
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i] + "\n");
        }

        System.out.print(sb);
    }
    
    static void check() {
        visit = new int[N + 1];
        Arrays.fill(visit, -1);
        visit[R] = 0;
        
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[] { R, 0 });

        int[] now;
        while (!q.isEmpty()) {
            now = q.poll();

            for (int nxt : board[now[0]]) {
                if (visit[nxt] != -1)
                    continue;

                visit[nxt] = now[1] + 1;
                q.offer(new int[] { nxt, now[1] + 1 });
            }
        }
    }
}
