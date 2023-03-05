import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SW_1249_2 {
    static int N, res;
    static boolean[][] visit;
    static int[][] board;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Node implements Comparable<Node> {
        int x, y, w;

        Node (int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            board = new int[N][N];
            visit = new boolean[N][N];

            String s;
            for (int i = 0; i < N; i++) {
                s = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = s.charAt(j) - '0';
                }
            }

            res = 987654321;
            check();
            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    static void check() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        visit[0][0] = true;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int x = now.x;
            int y = now.y;

            if (x == N-1 && y == N-1) {
                res = now.w;
                return;
            }

            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = x + moves[i][0];
                ny = y + moves[i][1];

                if (!isPossible(nx, ny) || visit[nx][ny]) continue;

                visit[nx][ny] = true;
                pq.offer(new Node(nx, ny, now.w + board[nx][ny]));
            }
            
        }
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}
