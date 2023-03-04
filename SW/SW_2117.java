import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2117 {
    static int N, M, K, cost, res;
    static int[][] board;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new int[N][N];

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if(board[i][j] == 1) cnt++;
                }
            }

            K = findMax(M * cnt);
            cost = setCost();

            res = 0;
            while (K > 0) { // 값이 바뀌는 순간 최대
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        visit = new boolean[N][N];
                        check(i, j);
                    }
                }
                if (res != 0) break;
                K--;
                cost = setCost();
            }

            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    static void check(int x, int y) {
        int cnt = board[x][y] == 1 ? 1 : 0;
        
        for (int i = 0; i < K; i++) {
            for (int j = 0; i + j < K; j++) {
                if (i == 0 && j == 0) continue;

                if (isPossible(x - i, y - j)) cnt++;
                if (isPossible(x - i, y + j)) cnt++;
                if (isPossible(x + i, y - j)) cnt++;
                if (isPossible(x + i, y + j)) cnt++;
            }
        }

        if (cnt < res) return;
        if (cnt * M >= cost) res = Math.max(res, cnt);
    }

    static int setCost() {
        return (K * K) + ((K-1) * (K-1)); 
    }

    static boolean isPossible(int x, int y) {
        if ((0 <= x && x < N) && (0 <= y && y < N) && (board[x][y] == 1) && !visit[x][y]) {
            return visit[x][y] = true;
        }
        return false;
    }

    // 가능한 최대 K 값 체크
    static int findMax(int std) {
        int v = 1;
        int tmp;
        while(true) {
            tmp = v * v + (v-1) * (v-1);
            if (tmp <= std) v++;
            else break;
        }

        return v-1;
    }
}
