package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class S2_2210 {

    static String[][] board;
    static Set<String> set;
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new String[5][5];
        for (int i = 0; i < 5; i++) {
            board[i] = br.readLine().split(" ");
        }

        set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                check(i, j, board[i][j]);
            }
        }

        System.out.print(set.size());
    }
    
    static void check(int x, int y, String s) {
        if (s.length() == 6) {
            set.add(s);
            return;
        }

        int nx, ny;
        for (int[] move : moves) {
            nx = x + move[0];
            ny = y + move[1];

            if (!isPossible(nx, ny))
                continue;
            
            check(nx, ny, s + board[nx][ny]);
        }
    }
    
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < 5) && (0 <= y && y < 5);
    }
}
