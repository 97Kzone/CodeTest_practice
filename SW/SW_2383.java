import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_2383 {
    static int N, M, res;
    static int[] select;
    static int[][] board;
    static ArrayList<int[]> people, stair; // 사람
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = 0;

            board = new int[N][N];
            stair = new ArrayList<>();
            people = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());

                    if(board[i][j] == 1) {
                        people.add(new int[] {i, j});
                        M++;
                    } else if(board[i][j] > 1) stair.add(new int[] {i, j, board[i][j]});
                }
            }
            select = new int[M];
            res = 987654321;
            dfs(0);
            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int cnt) {
        if (cnt == M) {
            check();
            return;
        }

        for (int i = 0; i < 2; i++) {
            select[cnt] = i;
            dfs(cnt + 1);
        }
    }

    static void check() {
        PriorityQueue<Integer>[] pq = new PriorityQueue[2];
        pq[0] = new PriorityQueue<>();
        pq[1] = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            pq[select[i]].add(checkDist(people.get(i), stair.get(select[i])));
        }

        int std = 0, size = M;
        int[][] state = new int[2][3];
        while (true) {
            if (size == 0 && isPossible(state)) break;
            
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (state[i][j] > 0) state[i][j]--;

                    if (state[i][j] == 0) {
                        if (!pq[i].isEmpty() && pq[i].peek() <= std) {
                            state[i][j] = stair.get(i)[2];
                            pq[i].poll();
                            size--;
                        }
                    }
                }
            }
            std++;
        }

        res = Math.min(res, std);
    }

    static boolean isPossible(int[][] arr) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] != 0) return false;
            }
        }
        return true;
    }
    static int checkDist(int[] xy, int[] xy2) {
        return Math.abs(xy[0] - xy2[0]) + Math.abs(xy[1] - xy2[1]);
    }
}
