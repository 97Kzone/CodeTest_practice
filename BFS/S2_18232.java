package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_18232 {

    static int N, M, S, E, res;
    static boolean[] visit;
    static Map<Integer, List<Integer>> door;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        door = new HashMap<>();
        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            door.computeIfAbsent(s, k -> new ArrayList<>()).add(e);
            door.computeIfAbsent(e, k -> new ArrayList<>()).add(s);
        }

        check();
        System.out.print(res);
    }

    static void check() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{S, 0});
        visit = new boolean[N + 1];
        visit[S] = true;

        int idx, cnt;
        int[] moves;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            idx = now[0];
            cnt = now[1];

            if (idx == E) {
                res = cnt;
                return;
            }

            moves = new int[]{idx + 1, idx - 1};
            for (int next : moves) {
                if (isPossible(next) && !visit[next]) {
                    visit[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
            }

            if (door.containsKey(idx)) {
                for (int tp : door.get(idx)) {
                    if (isPossible(tp) && !visit[tp]) {
                        visit[tp] = true;
                        q.offer(new int[]{tp, cnt + 1});
                    }
                }
            }
        }
    }

    static boolean isPossible(int x) {
        return (0 < x && x <= N);
    }
}
