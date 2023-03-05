import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5653 {
    static int N, M, K, size, res;
    static boolean[][] visit; // 이건 필요해
    static PriorityQueue<int[]> pq;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            size = Math.max(N, M) + K * 2;
            visit = new boolean[size][size];

            pq = new PriorityQueue<int[]>((o1, o2) -> (o2[2] - o1[2]));

            int v;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    v = Integer.parseInt(st.nextToken());
                    
                    if (v== 0) continue;
                       
                    pq.offer(new int[] {i + K, j + K, v, v}); // 좌표, 값
                    visit[i+K][j+K] = true;
                }
            }

            res = 0;
            check();
            
            sb.append("#" + t + " ").append(pq.size() + "\n");
        }
        System.out.print(sb.toString());
    }

    static void check() {
        Queue<int[]> tmp = new ArrayDeque<>();
        
        int nx, ny;
        while (K > 0) {
            while(!pq.isEmpty()) {
                int[] now = pq.poll();

                now[3]--;
                if (now[3] < 0) {
                    for (int i = 0; i < 4; i++) {
                        nx = now[0] + moves[i][0];
                        ny = now[1] + moves[i][1];

                        if(!isPossible(nx, ny) || visit[nx][ny]) continue;

                        visit[nx][ny] = true;
                        tmp.offer(new int[] {nx, ny, now[2], now[2]});
                    }
                }
                
                if (now[2] + now[3] == 0) continue;
                tmp.offer(now);
            }

            while (!tmp.isEmpty()) pq.offer(tmp.poll());
            K--;
        }

    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < size) && (0 <= y && y < size);
    }
}
