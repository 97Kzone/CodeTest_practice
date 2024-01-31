package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_14711 {

    static int N;
    static char[][] board;
    static int[][] cnt;
    static int[][] moves = { { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        cnt = new int[N][N];

        String s = br.readLine();
        for (int i = 0; i < N; i++)
            board[0][i] = s.charAt(i);

        sb.append(s + "\n");
        int nx, ny;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '#') {
                    cnt[i][j]++;

                    for (int[] move : moves) {
                        nx = i + move[0];
                        ny = j + move[1];

                        if (!isPossible(nx, ny))
                            continue;
                        cnt[nx][ny]++;
                    }
                }
            }
            
            for (int j = 0; j < N; j++) {
                if (cnt[i][j] % 2 == 0) board[i + 1][j] = board[i][j] == '#' ? '#' : '.';
                else board[i + 1][j] = board[i][j] == '#' ? '.' : '#';

                sb.append(board[i + 1][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    } 
}
