package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class G5_19940 {

    static int N;
    static List<int[]> time;
    static Set<Integer> visit = new HashSet<>();
    static int[] moves = { 0, 60, 10, -10, 1, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init(); // 1 ~ 59분 경우를 미리 구해놓기
        int T = Integer.parseInt(br.readLine());
        
        int div, mod;
        int[] res;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            div = N / 60;
            mod = N % 60;
            res = time.get(mod);
            sb.append(res[1] + div + " " + res[2] + " " + res[3] + " " + res[4] + " " + res[5] + "\n");
        }
        System.out.print(sb.toString());
    }
    
    static void check(int target) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0, 0, 0, 0, 0 });

        visit.clear();
        visit.add(0);

        int[] now;
        int nxt;
        while (!q.isEmpty()) {
            now = q.poll();

            if (now[0] == target) {
                time.add(now);
                return;
            }

            for (int i = 5; i >= 1; i--) {
                nxt = now[0] + moves[i];

                if (visit.contains(nxt) || nxt < 0) {
                    continue;
                }

                visit.add(nxt);
                now[i]++;
                q.offer(new int[] { nxt, now[1], now[2], now[3], now[4], now[5] });
                now[i]--;
            }
        }

    }
    
    static void init() {
        time = new ArrayList<>();
        time.add(new int[] {0, 0, 0, 0, 0, 0});
        for (int i = 1; i < 60; i++) {
            check(i);
        }
    }
}
