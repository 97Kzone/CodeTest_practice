package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2615 {
    static int res;
    static int[][] board;
    static int[][] moves = {{1, 0}, {0, 1}, {1, 1}, {-1, 1}}; // 하, 오, 오대각, 좌대각
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[20][20];

        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if (board[i][j] == 1 || board[i][j] == 2) {
                    if (check(i, j, board[i][j])) {
                        System.out.println(board[i][j]);
                        System.out.print(i + " " + j);
                        return;
                    }
                }
            }
        }

        System.out.print(0);
    }

    // 오목 확인
    static boolean check(int x, int y, int flag) {
        int nx, ny, cnt;

        for (int i = 0; i < 4; i++) {
            cnt = 1;
            
            nx = x + moves[i][0];
            ny = y + moves[i][1];
            
            if (isPossible(nx, ny)) {
                if (board[nx][ny] == 0) continue;
                if (board[x - moves[i][0]][y - moves[i][1]] == flag) continue;
                
                while(isPossible(nx, ny) && board[nx][ny] == flag) {
                    cnt++;
                    nx += moves[i][0];
                    ny += moves[i][1];
                }
                
                if (cnt == 5) return true;
            }
        }

        return false;
    }

    // 범위 확인
    static boolean isPossible(int x, int y) {
        if (x > 0 && y > 0 && x < 20 && y < 20) return true;
        return false;
    }


}
