package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_9205 {
    static int N;
    static int sx, sy, ex, ey; // 시작 x, y, 도착 x, y;
    static List<int[]> board;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            board = new ArrayList<>();

            //출발 좌표
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            // 편의점 들
            int x, y;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                board.add(new int[] {x, y});
            }

            //도착 좌표
            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            // 탐색 시작
            visit = new boolean[N];
            sb.append(check() + "\n");
        }
        System.out.print(sb.toString());
    }

    static String check() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sx, sy});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            // 도착지까지 갈 수 있으면 happy
            if (Math.abs(now[0] - ex) + Math.abs(now[1] - ey) <= 1000) return "happy";
            
            // 편의점을 순차적으로 돌면서 갈 수 있는지 체크
            for (int i = 0; i < N; i++) {
                if (visit[i]) continue;

                int[] nxt = board.get(i);
                if(Math.abs(nxt[0] - now[0]) + Math.abs(nxt[1] - now[1]) <= 1000) {
                    visit[i] = true;
                    q.offer(nxt);
                }
            }
        }
        return "sad";
    }
}
