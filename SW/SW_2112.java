import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2112 {
    static int D, W, K, res;
    static int[][] board, cboard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            board = new int[D][W];
            cboard = new int[D][W];
            
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    cboard[i][j] = board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = 987654321;
            if (K == 1) { // 따질게 없는 경우
                sb.append("#" + t + " ").append(0 + "\n");
                continue;
            }

            check(0, 0);
            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    static void check(int idx, int cnt) {
        if (cnt > res) return;

        if (idx == D) {
            if (isPossible()) { // 가능성 체크
                res = Math.min(res, cnt);
            }
            return;
        }

        check(idx + 1, cnt); // 현재 필름 변경 X, 다음 필름 확인

        for (int i = 0; i < W; i++) board[idx][i] = 0; // 현재 필름 A 사용
        check(idx + 1, cnt + 1);

        for (int i = 0; i < W; i++) board[idx][i] = 1; // 현재 필름 B 사용
        check(idx + 1, cnt + 1);

        for (int i = 0; i < W; i++) board[idx][i] = cboard[idx][i];
    }

    static boolean isPossible() {
        for (int j = 0; j < W; j++) {
            int cnt = 1;
            boolean flag = false;
            for (int i = 1; i < D; i++) {
                if (board[i][j] == board[i-1][j]) cnt++;
                else cnt = 1;

                if (cnt == K) {
                    flag = true;
                    break;
                }
            }

            if (!flag) return false;
        }
        return true;
    }
}
