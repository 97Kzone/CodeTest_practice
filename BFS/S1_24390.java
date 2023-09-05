package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S1_24390 {
    static int[] moves = { 10, 30, 60, 600 };
    static boolean[] visit;
    static int time, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        time = time2sec(s);

        res = 0;
        visit = new boolean[3601];
        bfs();

        System.out.print(res);
    }

    static void bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        pq.offer(new int[] { 0, 0, 0 });

        visit[0] = true;

        int[] now;
        while (!pq.isEmpty()) {
            now = pq.poll();
            if (now[0] == time) {
                res = now[1] == 1 ? now[2] : now[2] + 1;
                return;
            }

            int nxt;
            for (int move : moves) {
                nxt = now[0] + move;

                if (!isPossible(nxt) || visit[nxt])
                    continue;

                if (move == 30 && now[1] == 0)
                    pq.offer(new int[] { nxt, 1, now[2] + 1 });
                else
                    pq.offer(new int[] { nxt, now[1], now[2] + 1 });
                visit[nxt] = true;
            }
        }

    }

    static boolean isPossible(int v) {
        return 0 <= v && v <= 3600;
    }

    static int time2sec(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}
