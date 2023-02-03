import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_5643 {
    static int N, M, res;
    static boolean[][] board;
    static boolean[] check;

    static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            board = new boolean[N+1][N+1];
            res = 0;

            int s, e;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());

                board[s][e] = true;
            }

            for (int i = 1; i < N+1; i++) {
                check = new boolean[N+1];
                if (dfs(i)) res += 1;
            }

            System.out.printf("#%d %d\n", t, res);
        }
    }
    static boolean dfs(int idx) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {idx, 0});
        check[idx] = true;

        int cnt = 0;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int now = tmp[0];
            int v = tmp[1];

            cnt += 1;

            for (int i = 1; i < N+1; i++) {
                if (check[i]) continue; // 가지치기

                if (v >= 0 && board[now][i]) {
                    q.offer(new int[] {i, 1});
                    check[i] = true;
                }

                if (v <= 0 && board[i][now]) {
                    q.offer(new int[] {i, -1});
                    check[i] = true;
                }
            }
        }

        return cnt == N;
    }
    public static void main(String[] args) throws IOException {
        sol();
    }
}
