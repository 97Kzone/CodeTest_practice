package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_20125 {

    static int N;
    static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new String[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ("_".equals(board[i][j]))
                    continue;
                if (!check(i, j))
                    continue;

                sb.append((i + 1) + " " + (j + 1) + "\n");

                // 1. 왼팔 찾기
                int cnt = 0;
                int idx = j - 1;
                while (idx >= 0) {
                    if ("_".equals(board[i][idx])) {
                        break;
                    }
                    idx--;
                    cnt++;
                }
                sb.append(cnt + " ");

                // 2. 오른팔
                cnt = 0;
                idx = j + 1;
                while (idx < N) {
                    if ("_".equals(board[i][idx])) {
                        break;
                    }
                    idx++;
                    cnt++;
                }
                sb.append(cnt + " ");

                // 3. 허리
                cnt = 0;
                idx = i + 1;
                while (idx < N) {
                    if ("_".equals(board[idx][j])) {
                        break;
                    }
                    idx++;
                    cnt++;
                }
                sb.append(cnt + " ");

                // 4. 왼발
                cnt = 0;
                int std = idx;
                while (std < N) {
                    if ("_".equals(board[std][j - 1])) {
                        break;
                    }
                    std++;
                    cnt++;
                }
                sb.append(cnt + " ");

                // 5. 오른발
                cnt = 0;
                std = idx;
                while (std < N) {
                    if ("_".equals(board[std][j + 1])) {
                        break;
                    }
                    std++;
                    cnt++;
                }
                sb.append(cnt + " ");
                
                System.out.print(sb);
                return;
            }
        }
    }
    
    static boolean check(int x, int y) {

        if (!isPossible(x-1, y) || "_".equals(board[x - 1][y])) return false;
        if (!isPossible(x, y-1) || "_".equals(board[x][y-1])) return false;
        if (!isPossible(x+1, y) || "_".equals(board[x +1][y])) return false;
        if (!isPossible(x, y + 1) || "_".equals(board[x][y + 1])) return false;
        
        return true;
    }
    
    
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}
