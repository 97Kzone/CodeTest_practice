package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_17616 {

    static int N, M, K;
    static ArrayList<Integer>[] list1, list2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list1 = new ArrayList[N + 1];
        list2 = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list1[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            list1[a].add(b);
            list2[b].add(a);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(K);

        boolean[] visit = new boolean[N + 1];
        visit[K] = true;

        int v1 = check(list1);
        int v2 = check(list2);

        System.out.print((v2 + 1) + " " + (N - v1));
    }
    
    static int check(ArrayList<Integer>[] list) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(K);

        boolean[] visit = new boolean[N + 1];
        visit[K] = true;

        int res = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int nxt : list[now]) {
                if (visit[nxt])
                    continue;

                visit[nxt] = true;
                q.offer(nxt);
                res++;
            }
        }

        return res;
    }
}
