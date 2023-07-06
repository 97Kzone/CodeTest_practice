package PG_Level2;

import java.util.*;

class Solution {

    static int N, M;
    static String[][] board;
    static List<Integer> res;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        board = new String[N][M];
        res = new ArrayList<>();

        for (int i = 0; i < N; i++) board[i] = maps[i].split("");

        int val;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!"X".equals(board[i][j])) {
                    res.add(check(i, j));
                }
            }
        }

        Collections.sort(res);

        if (res.size() == 0) return new int[] {-1};

        int[] answer = new int[res.size()]; 
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i); 
        return answer;
    }

    static int check(int i, int j) {
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[] {i, j});

        int v = Integer.parseInt(board[i][j]);
        board[i][j] = "X";

        int x, y, nx, ny;
        while(!q.isEmpty()) {
            int[] now = q.poll();

            x = now[0];
            y = now[1];

            for (int[] move : moves) {
                nx = x + move[0];
                ny = y + move[1];

                if ( !isPossible(nx, ny) || "X".equals(board[nx][ny])) continue;
                v += Integer.parseInt(board[nx][ny]);
                q.offer(new int[] {nx, ny});
                board[nx][ny] = "X";
            }
        }

        return v;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
