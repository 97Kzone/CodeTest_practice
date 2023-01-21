package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class G5_13549 {
    static int N, K;
    static int[] visit;
    static int[] moves = {-1, 1};
    public static void main(String[] args) throws IOException {
        sol();
    }

    static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // N 이 K 보다 크면 한칸씩 가는게 최선
        if (K <= N) {
            System.out.println(N-K);
        } else {
            visit = new int[100001];
            Arrays.fill(visit, -1);
            visit[N] = 0;
            bfs();
        }
    }
    
    //좌, 우 이동보다 순간이동 우선
    static void bfs() {
        Deque<Integer> q = new LinkedList<>();
        q.add(N);
        int v;
        while (!q.isEmpty()) {
            v = q.pollFirst();
            if (v == K) {
                System.out.println(visit[v]);
                break;
            }

            //순간이동
            if (v*2 <= 100000 && visit[v*2] == -1) {
                q.addFirst(v*2);
                visit[v*2] = visit[v];
            }

            // 좌, 우 이동
            for (int i = 0; i < 2; i++) {
                int nx = v + moves[i];
                if (nx >= 0 && nx < 100001 && visit[nx] == -1) {
                    visit[nx] = visit[v] + 1;
                    q.add(nx);
                }
            }
        }
    }
}
