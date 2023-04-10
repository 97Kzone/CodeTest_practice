package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_17136 {
    static int[][] board;
    static int[] count; // 사용한 색종이 개수
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st;

        board = new int[10][10];
        count = new int[6];

        // 1. 맵 채우기
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 25; // 종이는 최대 25장
        dfs(0, 0, 0);

        res = res == 25 ? -1 : res;
        System.out.print(res);
    }

    // 재귀 탐색
    static void dfs(int x, int y, int cnt) {
        if (x == 10) {
            res = Math.min(res, cnt);
            return;
        }

        if (y == 10) {
            dfs(x + 1, 0, cnt);
            return;
        }

        if (board[x][y] == 0) {
            dfs(x, y + 1, cnt);
            return;
        } else {
            for (int i = 1; i < 6; i++) {
                if(check(x, y, i)) {
                    cover(x, y, i, 0);
                    dfs(x, y + 1, cnt + 1);
                    cover(x, y, i, 1);
                }
            }
        }
    }

    // 색종이 덮기
    static void cover(int x, int y, int w, int v) {
        for (int i = x; i < x + w; i++) {
            for (int j = y; j < y + w; j++) {
                board[i][j] = v;
            }
        }

        count[w] += v == 0 ? 1 : -1;
    }

    // N x N 사각형이 성립하는가 ?
    static boolean check(int x, int y, int w) {
        if (count[w] == 5) return false;

        if (x + w > 10 || y + w > 10) return false;

        for (int i = x; i < x + w; i++) {
            for (int j = y; j < y + w; j++) {
                if (board[i][j] == 0) return false;
            }
        }

        return true;
    }
}
