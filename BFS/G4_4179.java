package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_4179 {
    
    static int N, M;
    static char[][] board;
    static Queue<int[]> q;
    static Queue<int[]> fires;
    static boolean[][] v1, v2;
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        q = new ArrayDeque<>();
        fires = new ArrayDeque<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        v1 = new boolean[N][M];
        v2 = new boolean[N][M];


        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'J') {
                    board[i][j] = '.';
                    q.offer(new int[] { i, j });
                    v1[i][j] = true;
                } else if(board[i][j] == 'F') {
                    fires.offer(new int[] { i, j });
                    v2[i][j] = true;
                }
            }
        }

        bfs();
        System.out.println("IMPOSSIBLE");
    }

    static void bfs() {
        int time = 0;

        while(!q.isEmpty()) {
            int s1 = q.size();
            int s2 = fires.size();
            for(int i = 0; i < s2; i++) {
                int[] fire = fires.poll();

                for(int d=0; d<4; d++) {
                    int nx = fire[0] + moves[d][0];
                    int ny = fire[1] + moves[d][1];

                    if(!isPossible(nx, ny) || board[nx][ny] == '#' || v2[nx][ny]) continue;
                    v2[nx][ny] = true;
                    board[nx][ny] = 'F';
                    fires.offer(new int[] { nx, ny });
                }
            }
            for(int i = 0; i < s1; i++) {
                int[] now = q.poll();
                for(int d = 0; d < 4; d++) {
                    int nx = now[0] + moves[d][0];
                    int ny = now[1] + moves[d][1];

                    if(!isPossible(nx, ny)) {
                        time++;
                        System.out.println(time);
                        System.exit(0);
                    }

                    if(board[nx][ny] !='.' || v1[nx][ny]) continue;
                    v1[nx][ny] = true;
                    q.add(new int[] { nx, ny });
                }
            }

            time++;
        }
    }

    private static boolean isPossible(int x, int y){
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}